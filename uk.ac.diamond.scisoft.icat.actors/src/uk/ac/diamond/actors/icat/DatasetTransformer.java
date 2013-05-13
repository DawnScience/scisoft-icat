package uk.ac.diamond.actors.icat;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.dawb.passerelle.common.actors.AbstractDataMessageTransformer;
import org.dawb.passerelle.common.message.DataMessageComponent;
import org.dawb.passerelle.common.message.IVariable;
import org.dawb.passerelle.common.message.IVariableProvider;
import org.dawb.passerelle.common.message.MessageUtils;
import org.dawb.passerelle.common.message.Variable;
import org.dawb.passerelle.common.message.IVariable.VARIABLE_TYPE;
import org.icatproject.Dataset;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ptolemy.data.expr.StringParameter;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.Attribute;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

import com.isencia.passerelle.actor.ProcessingException;
import com.isencia.passerelle.actor.TerminationException;
import com.isencia.passerelle.util.ptolemy.FileParameter;
import com.thoughtworks.xstream.XStream;

public class DatasetTransformer extends AbstractDataMessageTransformer implements IVariableProvider {

	private static final long serialVersionUID = 13128887976847L;

	private Dataset datasetResult = null;
	private String id;
	private String outputFile;

	private StringParameter datasetParam;
	private FileParameter outputFileParam;
	
	XStream xstream = new XStream();

	public DatasetTransformer(CompositeEntity container, String name) throws NameDuplicationException, IllegalActionException {
		super(container, name);
			
		datasetParam = new StringParameter(this, "Dataset ID");
		id = datasetParam.getExpression();
		registerConfigurableParameter(datasetParam);
		
		File fileExample = new File(System.getProperty("user.home"),"result.xml");

		outputFileParam = new FileParameter(this, "Result File");
		outputFileParam.setExpression(fileExample.getAbsolutePath());
		outputFile = outputFileParam.getExpression();
		registerConfigurableParameter(outputFileParam);

	}

	@Override
	protected String getOperationName() {
		return "Creates a Dataset ICAT actor";
	}

	public void attributeChanged(Attribute attribute) throws IllegalActionException {
		if (attribute == datasetParam){
			id = datasetParam.getExpression();
		}else if (attribute == outputFileParam){
			outputFile = outputFileParam.getExpression();
		}
		
		super.attributeChanged(attribute);
	}

	@Override
	protected DataMessageComponent getTransformedMessage(List<DataMessageComponent> cache) throws ProcessingException {

		final DataMessageComponent comp = new DataMessageComponent();

		try {
					
			final Map<String,String> scalar = MessageUtils.getScalar(cache);
			final String token    = scalar!=null ? scalar.get("token") : null;
														
			final ICATClient client = Sessions.getSession(token);	
							
			datasetResult = client.getDataset(Long.valueOf(id));
			
			comp.addScalar(scalar);
			comp.putScalar("dataset_result", xstream.toXML(datasetResult));
			comp.putScalar("file_path", outputFile);
			
			// save result into file
			writeToFile( xstream.toXML(datasetResult) , new File(outputFile));
						
		} catch (Exception ne) {
			
			comp.putScalar("error_text", "Error getting result from ICAT");
		}
		return comp; 
	}
	
	// write result to file
	private void writeToFile(String xml, File file) {
		
		try {
			 
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
 
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(xml);
			bw.close();
 
			logger.debug("Result written to " + file.getAbsolutePath());
 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<IVariable> getOutputVariables() {
		
		final List<IVariable> ret = super.getOutputVariables();
		ret.add(new Variable("dataset_id",  VARIABLE_TYPE.SCALAR, id,  String.class));
		ret.add(new Variable("dataset_result",  VARIABLE_TYPE.SCALAR, xstream.toXML(datasetResult),  String.class));
			
        return ret;
	}
	
	public void doWrapUp() throws TerminationException {
		super.doWrapUp();
	}
	
	private static final Logger logger = LoggerFactory.getLogger(ConnectionTransformer.class);
		
}
