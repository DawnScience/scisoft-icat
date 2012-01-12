/*
 * Copyright 2012 Diamond Light Source Ltd.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.icat3.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the uk.icat3.client package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the
 * Java representation for XML content. The Java representation of XML content
 * can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory
 * methods for each of these are provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

	private final static QName _ModifyInvestigatorResponse_QNAME = new QName(
			"client.icat3.uk", "modifyInvestigatorResponse");
	private final static QName _SearchByRunNumber_QNAME = new QName(
			"client.icat3.uk", "searchByRunNumber");
	private final static QName _SearchByRunNumberPaginationResponse_QNAME = new QName(
			"client.icat3.uk", "searchByRunNumberPaginationResponse");
	private final static QName _GetMyInvestigationsResponse_QNAME = new QName(
			"client.icat3.uk", "getMyInvestigationsResponse");
	private final static QName _DeleteSample_QNAME = new QName(
			"client.icat3.uk", "deleteSample");
	private final static QName _CreateDataFileResponse_QNAME = new QName(
			"client.icat3.uk", "createDataFileResponse");
	private final static QName _DeleteKeyword_QNAME = new QName(
			"client.icat3.uk", "deleteKeyword");
	private final static QName _AddDataSetParameters_QNAME = new QName(
			"client.icat3.uk", "addDataSetParameters");
	private final static QName _Dataset_QNAME = new QName("client.icat3.uk",
			"dataset");
	private final static QName _RemoveKeywordResponse_QNAME = new QName(
			"client.icat3.uk", "removeKeywordResponse");
	private final static QName _GetDatasetResponse_QNAME = new QName(
			"client.icat3.uk", "getDatasetResponse");
	private final static QName _ModifyInvestigation_QNAME = new QName(
			"client.icat3.uk", "modifyInvestigation");
	private final static QName _GetAuthorisations_QNAME = new QName(
			"client.icat3.uk", "getAuthorisations");
	private final static QName _AddKeyword_QNAME = new QName("client.icat3.uk",
			"addKeyword");
	private final static QName _RemoveSampleResponse_QNAME = new QName(
			"client.icat3.uk", "removeSampleResponse");
	private final static QName _DatafileParameter_QNAME = new QName(
			"client.icat3.uk", "datafileParameter");
	private final static QName _ICATAPIException_QNAME = new QName(
			"client.icat3.uk", "ICATAPIException");
	private final static QName _AddPublicationResponse_QNAME = new QName(
			"client.icat3.uk", "addPublicationResponse");
	private final static QName _ModifyDataSetParameter_QNAME = new QName(
			"client.icat3.uk", "modifyDataSetParameter");
	private final static QName _DownloadDatafile_QNAME = new QName(
			"client.icat3.uk", "downloadDatafile");
	private final static QName _InsufficientPrivilegesException_QNAME = new QName(
			"client.icat3.uk", "InsufficientPrivilegesException");
	private final static QName _UpdateAuthorisationResponse_QNAME = new QName(
			"client.icat3.uk", "updateAuthorisationResponse");
	private final static QName _GetKeywordsForUser_QNAME = new QName(
			"client.icat3.uk", "getKeywordsForUser");
	private final static QName _ModifyInvestigationResponse_QNAME = new QName(
			"client.icat3.uk", "modifyInvestigationResponse");
	private final static QName _SetDataSetSample_QNAME = new QName(
			"client.icat3.uk", "setDataSetSample");
	private final static QName _DeleteDataSetParameter_QNAME = new QName(
			"client.icat3.uk", "deleteDataSetParameter");
	private final static QName _GetAuthorisationsResponse_QNAME = new QName(
			"client.icat3.uk", "getAuthorisationsResponse");
	private final static QName _CreateDataSet_QNAME = new QName(
			"client.icat3.uk", "createDataSet");
	private final static QName _GetDatasetIncludes_QNAME = new QName(
			"client.icat3.uk", "getDatasetIncludes");
	private final static QName _DeleteInvestigator_QNAME = new QName(
			"client.icat3.uk", "deleteInvestigator");
	private final static QName _DeleteKeywordResponse_QNAME = new QName(
			"client.icat3.uk", "deleteKeywordResponse");
	private final static QName _GetKeywordsForUserResponse_QNAME = new QName(
			"client.icat3.uk", "getKeywordsForUserResponse");
	private final static QName _GetDatasets_QNAME = new QName(
			"client.icat3.uk", "getDatasets");
	private final static QName _ListParameters_QNAME = new QName(
			"client.icat3.uk", "listParameters");
	private final static QName _ModifyDataFileParameter_QNAME = new QName(
			"client.icat3.uk", "modifyDataFileParameter");
	private final static QName _ModifyPublicationResponse_QNAME = new QName(
			"client.icat3.uk", "modifyPublicationResponse");
	private final static QName _GetKeywordsForUserStartWithMaxResponse_QNAME = new QName(
			"client.icat3.uk", "getKeywordsForUserStartWithMaxResponse");
	private final static QName _AddDataFileParameter_QNAME = new QName(
			"client.icat3.uk", "addDataFileParameter");
	private final static QName _DeleteDataSetParameterResponse_QNAME = new QName(
			"client.icat3.uk", "deleteDataSetParameterResponse");
	private final static QName _CreateInvestigation_QNAME = new QName(
			"client.icat3.uk", "createInvestigation");
	private final static QName _SearchDatasetsBySample_QNAME = new QName(
			"client.icat3.uk", "searchDatasetsBySample");
	private final static QName _DeleteDataFileParameter_QNAME = new QName(
			"client.icat3.uk", "deleteDataFileParameter");
	private final static QName _ListDatasetTypesResponse_QNAME = new QName(
			"client.icat3.uk", "listDatasetTypesResponse");
	private final static QName _CheckDatasetDownloadAccessResponse_QNAME = new QName(
			"client.icat3.uk", "checkDatasetDownloadAccessResponse");
	private final static QName _Datafile_QNAME = new QName("client.icat3.uk",
			"datafile");
	private final static QName _AddDataFileParametersResponse_QNAME = new QName(
			"client.icat3.uk", "addDataFileParametersResponse");
	private final static QName _IngestMetadata_QNAME = new QName(
			"client.icat3.uk", "ingestMetadata");
	private final static QName _GetDatafileResponse_QNAME = new QName(
			"client.icat3.uk", "getDatafileResponse");
	private final static QName _ListRoles_QNAME = new QName("client.icat3.uk",
			"listRoles");
	private final static QName _DeleteAuthorisation_QNAME = new QName(
			"client.icat3.uk", "deleteAuthorisation");
	private final static QName _LogoutResponse_QNAME = new QName(
			"client.icat3.uk", "logoutResponse");
	private final static QName _GetMyInvestigationsIncludesPagination_QNAME = new QName(
			"client.icat3.uk", "getMyInvestigationsIncludesPagination");
	private final static QName _UpdateAuthorisation_QNAME = new QName(
			"client.icat3.uk", "updateAuthorisation");
	private final static QName _GetDataset_QNAME = new QName("client.icat3.uk",
			"getDataset");
	private final static QName _GetKeywordsForUserMaxResponse_QNAME = new QName(
			"client.icat3.uk", "getKeywordsForUserMaxResponse");
	private final static QName _AddAuthorisationResponse_QNAME = new QName(
			"client.icat3.uk", "addAuthorisationResponse");
	private final static QName _Investigation_QNAME = new QName(
			"client.icat3.uk", "investigation");
	private final static QName _CheckDatafileDownloadAccessResponse_QNAME = new QName(
			"client.icat3.uk", "checkDatafileDownloadAccessResponse");
	private final static QName _AddSample_QNAME = new QName("client.icat3.uk",
			"addSample");
	private final static QName _DownloadDatasetResponse_QNAME = new QName(
			"client.icat3.uk", "downloadDatasetResponse");
	private final static QName _DeleteInvestigatorResponse_QNAME = new QName(
			"client.icat3.uk", "deleteInvestigatorResponse");
	private final static QName _AddAuthorisation_QNAME = new QName(
			"client.icat3.uk", "addAuthorisation");
	private final static QName _AddDataSetParameter_QNAME = new QName(
			"client.icat3.uk", "addDataSetParameter");
	private final static QName _CreateDataFiles_QNAME = new QName(
			"client.icat3.uk", "createDataFiles");
	private final static QName _CreateDataFilesResponse_QNAME = new QName(
			"client.icat3.uk", "createDataFilesResponse");
	private final static QName _ModifySampleParameter_QNAME = new QName(
			"client.icat3.uk", "modifySampleParameter");
	private final static QName _RemoveDataFileResponse_QNAME = new QName(
			"client.icat3.uk", "removeDataFileResponse");
	private final static QName _Investigator_QNAME = new QName(
			"client.icat3.uk", "investigator");
	private final static QName _DeleteInvestigation_QNAME = new QName(
			"client.icat3.uk", "deleteInvestigation");
	private final static QName _ListInstrumentsResponse_QNAME = new QName(
			"client.icat3.uk", "listInstrumentsResponse");
	private final static QName _RemoveKeyword_QNAME = new QName(
			"client.icat3.uk", "removeKeyword");
	private final static QName _RemoveInvestigation_QNAME = new QName(
			"client.icat3.uk", "removeInvestigation");
	private final static QName _GetDatasetsResponse_QNAME = new QName(
			"client.icat3.uk", "getDatasetsResponse");
	private final static QName _DeleteDataFileParameterResponse_QNAME = new QName(
			"client.icat3.uk", "deleteDataFileParameterResponse");
	private final static QName _Logout_QNAME = new QName("client.icat3.uk",
			"logout");
	private final static QName _SearchByAdvancedPagination_QNAME = new QName(
			"client.icat3.uk", "searchByAdvancedPagination");
	private final static QName _DeleteSampleParameterResponse_QNAME = new QName(
			"client.icat3.uk", "deleteSampleParameterResponse");
	private final static QName _AddDataSetParametersResponse_QNAME = new QName(
			"client.icat3.uk", "addDataSetParametersResponse");
	private final static QName _RemoveDataFile_QNAME = new QName(
			"client.icat3.uk", "removeDataFile");
	private final static QName _SearchByKeywordsAll_QNAME = new QName(
			"client.icat3.uk", "searchByKeywordsAll");
	private final static QName _GetDatafilesResponse_QNAME = new QName(
			"client.icat3.uk", "getDatafilesResponse");
	private final static QName _ModifyDataFileParameterResponse_QNAME = new QName(
			"client.icat3.uk", "modifyDataFileParameterResponse");
	private final static QName _ModifySample_QNAME = new QName(
			"client.icat3.uk", "modifySample");
	private final static QName _CreateDataFile_QNAME = new QName(
			"client.icat3.uk", "createDataFile");
	private final static QName _SetDataSetSampleResponse_QNAME = new QName(
			"client.icat3.uk", "setDataSetSampleResponse");
	private final static QName _SearchSamplesBySampleName_QNAME = new QName(
			"client.icat3.uk", "searchSamplesBySampleName");
	private final static QName _SearchByAdvancedPaginationResponse_QNAME = new QName(
			"client.icat3.uk", "searchByAdvancedPaginationResponse");
	private final static QName _RemoveInvestigatorResponse_QNAME = new QName(
			"client.icat3.uk", "removeInvestigatorResponse");
	private final static QName _GetInvestigationIncludes_QNAME = new QName(
			"client.icat3.uk", "getInvestigationIncludes");
	private final static QName _RemoveDataFileParameter_QNAME = new QName(
			"client.icat3.uk", "removeDataFileParameter");
	private final static QName _ModifyPublication_QNAME = new QName(
			"client.icat3.uk", "modifyPublication");
	private final static QName _ModifyDataSetParameterResponse_QNAME = new QName(
			"client.icat3.uk", "modifyDataSetParameterResponse");
	private final static QName _AddDataFileParameterResponse_QNAME = new QName(
			"client.icat3.uk", "addDataFileParameterResponse");
	private final static QName _RemoveDataSetParameter_QNAME = new QName(
			"client.icat3.uk", "removeDataSetParameter");
	private final static QName _RemoveSampleParameterResponse_QNAME = new QName(
			"client.icat3.uk", "removeSampleParameterResponse");
	private final static QName _GetMyInvestigations_QNAME = new QName(
			"client.icat3.uk", "getMyInvestigations");
	private final static QName _SearchByUserIDPaginationResponse_QNAME = new QName(
			"client.icat3.uk", "searchByUserIDPaginationResponse");
	private final static QName _NoSuchObjectFoundException_QNAME = new QName(
			"client.icat3.uk", "NoSuchObjectFoundException");
	private final static QName _GetMyInvestigationsIncludesPaginationResponse_QNAME = new QName(
			"client.icat3.uk", "getMyInvestigationsIncludesPaginationResponse");
	private final static QName _SearchByKeywords_QNAME = new QName(
			"client.icat3.uk", "searchByKeywords");
	private final static QName _CheckDatasetDownloadAccess_QNAME = new QName(
			"client.icat3.uk", "checkDatasetDownloadAccess");
	private final static QName _SearchByUserSurname_QNAME = new QName(
			"client.icat3.uk", "searchByUserSurname");
	private final static QName _ListDatasetStatusResponse_QNAME = new QName(
			"client.icat3.uk", "listDatasetStatusResponse");
	private final static QName _GetKeywordsForUserType_QNAME = new QName(
			"client.icat3.uk", "getKeywordsForUserType");
	private final static QName _GetInvestigationsIncludes_QNAME = new QName(
			"client.icat3.uk", "getInvestigationsIncludes");
	private final static QName _CheckDatafileDownloadAccess_QNAME = new QName(
			"client.icat3.uk", "checkDatafileDownloadAccess");
	private final static QName _DownloadDatafiles_QNAME = new QName(
			"client.icat3.uk", "downloadDatafiles");
	private final static QName _DeleteInvestigationResponse_QNAME = new QName(
			"client.icat3.uk", "deleteInvestigationResponse");
	private final static QName _RemovePublication_QNAME = new QName(
			"client.icat3.uk", "removePublication");
	private final static QName _FacilityUser_QNAME = new QName(
			"client.icat3.uk", "facilityUser");
	private final static QName _ListDatasetStatus_QNAME = new QName(
			"client.icat3.uk", "listDatasetStatus");
	private final static QName _GetKeywordsForUserTypeResponse_QNAME = new QName(
			"client.icat3.uk", "getKeywordsForUserTypeResponse");
	private final static QName _SearchByRunNumberPagination_QNAME = new QName(
			"client.icat3.uk", "searchByRunNumberPagination");
	private final static QName _RemoveDataSet_QNAME = new QName(
			"client.icat3.uk", "removeDataSet");
	private final static QName _DeleteSampleResponse_QNAME = new QName(
			"client.icat3.uk", "deleteSampleResponse");
	private final static QName _ModifySampleResponse_QNAME = new QName(
			"client.icat3.uk", "modifySampleResponse");
	private final static QName _RemovePublicationResponse_QNAME = new QName(
			"client.icat3.uk", "removePublicationResponse");
	private final static QName _ListInvestigationTypes_QNAME = new QName(
			"client.icat3.uk", "listInvestigationTypes");
	private final static QName _ListParametersResponse_QNAME = new QName(
			"client.icat3.uk", "listParametersResponse");
	private final static QName _SearchByUserIDResponse_QNAME = new QName(
			"client.icat3.uk", "searchByUserIDResponse");
	private final static QName _RemoveSampleParameter_QNAME = new QName(
			"client.icat3.uk", "removeSampleParameter");
	private final static QName _AddInvestigator_QNAME = new QName(
			"client.icat3.uk", "addInvestigator");
	private final static QName _RemoveDataSetResponse_QNAME = new QName(
			"client.icat3.uk", "removeDataSetResponse");
	private final static QName _SearchByKeywordsAllResponse_QNAME = new QName(
			"client.icat3.uk", "searchByKeywordsAllResponse");
	private final static QName _RemoveInvestigationResponse_QNAME = new QName(
			"client.icat3.uk", "removeInvestigationResponse");
	private final static QName _ListInvestigationTypesResponse_QNAME = new QName(
			"client.icat3.uk", "listInvestigationTypesResponse");
	private final static QName _GetDatafiles_QNAME = new QName(
			"client.icat3.uk", "getDatafiles");
	private final static QName _GetMyInvestigationsIncludes_QNAME = new QName(
			"client.icat3.uk", "getMyInvestigationsIncludes");
	private final static QName _DeleteDataSet_QNAME = new QName(
			"client.icat3.uk", "deleteDataSet");
	private final static QName _DeleteSampleParameter_QNAME = new QName(
			"client.icat3.uk", "deleteSampleParameter");
	private final static QName _GetKeywordsForUserMax_QNAME = new QName(
			"client.icat3.uk", "getKeywordsForUserMax");
	private final static QName _AddPublication_QNAME = new QName(
			"client.icat3.uk", "addPublication");
	private final static QName _SearchByUserIDPagination_QNAME = new QName(
			"client.icat3.uk", "searchByUserIDPagination");
	private final static QName _SessionException_QNAME = new QName(
			"client.icat3.uk", "SessionException");
	private final static QName _GetInvestigation_QNAME = new QName(
			"client.icat3.uk", "getInvestigation");
	private final static QName _DeleteAuthorisationResponse_QNAME = new QName(
			"client.icat3.uk", "deleteAuthorisationResponse");
	private final static QName _GetDatafile_QNAME = new QName(
			"client.icat3.uk", "getDatafile");
	private final static QName _ModifyDataFile_QNAME = new QName(
			"client.icat3.uk", "modifyDataFile");
	private final static QName _DeleteDataSetResponse_QNAME = new QName(
			"client.icat3.uk", "deleteDataSetResponse");
	private final static QName _LoginLifetime_QNAME = new QName(
			"client.icat3.uk", "loginLifetime");
	private final static QName _DeletePublicationResponse_QNAME = new QName(
			"client.icat3.uk", "deletePublicationResponse");
	private final static QName _Login_QNAME = new QName("client.icat3.uk",
			"login");
	private final static QName _DeletePublication_QNAME = new QName(
			"client.icat3.uk", "deletePublication");
	private final static QName _ListDatafileFormatsResponse_QNAME = new QName(
			"client.icat3.uk", "listDatafileFormatsResponse");
	private final static QName _CreateInvestigationResponse_QNAME = new QName(
			"client.icat3.uk", "createInvestigationResponse");
	private final static QName _ModifyInvestigator_QNAME = new QName(
			"client.icat3.uk", "modifyInvestigator");
	private final static QName _IngestMetadataResponse_QNAME = new QName(
			"client.icat3.uk", "ingestMetadataResponse");
	private final static QName _ListDatafileFormats_QNAME = new QName(
			"client.icat3.uk", "listDatafileFormats");
	private final static QName _LoginLifetimeResponse_QNAME = new QName(
			"client.icat3.uk", "loginLifetimeResponse");
	private final static QName _GetKeywordsForUserStartWithMax_QNAME = new QName(
			"client.icat3.uk", "getKeywordsForUserStartWithMax");
	private final static QName _AddKeywordResponse_QNAME = new QName(
			"client.icat3.uk", "addKeywordResponse");
	private final static QName _SearchByAdvanced_QNAME = new QName(
			"client.icat3.uk", "searchByAdvanced");
	private final static QName _ModifySampleParameterResponse_QNAME = new QName(
			"client.icat3.uk", "modifySampleParameterResponse");
	private final static QName _GetInvestigationIncludesResponse_QNAME = new QName(
			"client.icat3.uk", "getInvestigationIncludesResponse");
	private final static QName _ModifyDataFileResponse_QNAME = new QName(
			"client.icat3.uk", "modifyDataFileResponse");
	private final static QName _GetAllKeywordsResponse_QNAME = new QName(
			"client.icat3.uk", "getAllKeywordsResponse");
	private final static QName _SearchByRunNumberResponse_QNAME = new QName(
			"client.icat3.uk", "searchByRunNumberResponse");
	private final static QName _CreateDataSets_QNAME = new QName(
			"client.icat3.uk", "createDataSets");
	private final static QName _SearchByKeywordsResponse_QNAME = new QName(
			"client.icat3.uk", "searchByKeywordsResponse");
	private final static QName _RemoveInvestigator_QNAME = new QName(
			"client.icat3.uk", "removeInvestigator");
	private final static QName _DownloadDataset_QNAME = new QName(
			"client.icat3.uk", "downloadDataset");
	private final static QName _AddSampleResponse_QNAME = new QName(
			"client.icat3.uk", "addSampleResponse");
	private final static QName _AddDataFileParameters_QNAME = new QName(
			"client.icat3.uk", "addDataFileParameters");
	private final static QName _AddInvestigatorResponse_QNAME = new QName(
			"client.icat3.uk", "addInvestigatorResponse");
	private final static QName _LoginResponse_QNAME = new QName(
			"client.icat3.uk", "loginResponse");
	private final static QName _ValidationException_QNAME = new QName(
			"client.icat3.uk", "ValidationException");
	private final static QName _RemoveAuthorisation_QNAME = new QName(
			"client.icat3.uk", "removeAuthorisation");
	private final static QName _GetMyInvestigationsIncludesResponse_QNAME = new QName(
			"client.icat3.uk", "getMyInvestigationsIncludesResponse");
	private final static QName _SearchDatasetsBySampleResponse_QNAME = new QName(
			"client.icat3.uk", "searchDatasetsBySampleResponse");
	private final static QName _DeleteDataFileResponse_QNAME = new QName(
			"client.icat3.uk", "deleteDataFileResponse");
	private final static QName _RemoveDataSetParameterResponse_QNAME = new QName(
			"client.icat3.uk", "removeDataSetParameterResponse");
	private final static QName _SearchByAdvancedResponse_QNAME = new QName(
			"client.icat3.uk", "searchByAdvancedResponse");
	private final static QName _RemoveSample_QNAME = new QName(
			"client.icat3.uk", "removeSample");
	private final static QName _ListInstruments_QNAME = new QName(
			"client.icat3.uk", "listInstruments");
	private final static QName _ListRolesResponse_QNAME = new QName(
			"client.icat3.uk", "listRolesResponse");
	private final static QName _CreateDataSetResponse_QNAME = new QName(
			"client.icat3.uk", "createDataSetResponse");
	private final static QName _DownloadDatafileResponse_QNAME = new QName(
			"client.icat3.uk", "downloadDatafileResponse");
	private final static QName _ListDatasetTypes_QNAME = new QName(
			"client.icat3.uk", "listDatasetTypes");
	private final static QName _RemoveAuthorisationResponse_QNAME = new QName(
			"client.icat3.uk", "removeAuthorisationResponse");
	private final static QName _SearchByUserID_QNAME = new QName(
			"client.icat3.uk", "searchByUserID");
	private final static QName _GetDatasetIncludesResponse_QNAME = new QName(
			"client.icat3.uk", "getDatasetIncludesResponse");
	private final static QName _SearchSamplesBySampleNameResponse_QNAME = new QName(
			"client.icat3.uk", "searchSamplesBySampleNameResponse");
	private final static QName _AddDataSetParameterResponse_QNAME = new QName(
			"client.icat3.uk", "addDataSetParameterResponse");
	private final static QName _SearchByUserSurnamePagination_QNAME = new QName(
			"client.icat3.uk", "searchByUserSurnamePagination");
	private final static QName _AddSampleParameterResponse_QNAME = new QName(
			"client.icat3.uk", "addSampleParameterResponse");
	private final static QName _DownloadDatafilesResponse_QNAME = new QName(
			"client.icat3.uk", "downloadDatafilesResponse");
	private final static QName _SearchByUserSurnamePaginationResponse_QNAME = new QName(
			"client.icat3.uk", "searchByUserSurnamePaginationResponse");
	private final static QName _DeleteDataFile_QNAME = new QName(
			"client.icat3.uk", "deleteDataFile");
	private final static QName _GetInvestigationResponse_QNAME = new QName(
			"client.icat3.uk", "getInvestigationResponse");
	private final static QName _AddSampleParameter_QNAME = new QName(
			"client.icat3.uk", "addSampleParameter");
	private final static QName _ModifyDataSet_QNAME = new QName(
			"client.icat3.uk", "modifyDataSet");
	private final static QName _ModifyDataSetResponse_QNAME = new QName(
			"client.icat3.uk", "modifyDataSetResponse");
	private final static QName _GetInvestigationsIncludesResponse_QNAME = new QName(
			"client.icat3.uk", "getInvestigationsIncludesResponse");
	private final static QName _CreateDataSetsResponse_QNAME = new QName(
			"client.icat3.uk", "createDataSetsResponse");
	private final static QName _RemoveDataFileParameterResponse_QNAME = new QName(
			"client.icat3.uk", "removeDataFileParameterResponse");
	private final static QName _GetAllKeywords_QNAME = new QName(
			"client.icat3.uk", "getAllKeywords");
	private final static QName _SearchByUserSurnameResponse_QNAME = new QName(
			"client.icat3.uk", "searchByUserSurnameResponse");

	/**
	 * Create a new ObjectFactory that can be used to create new instances of
	 * schema derived classes for package: uk.icat3.client
	 * 
	 */
	public ObjectFactory() {
	}

	/**
	 * Create an instance of {@link SearchByAdvancedPaginationResponse }
	 * 
	 */
	public SearchByAdvancedPaginationResponse createSearchByAdvancedPaginationResponse() {
		return new SearchByAdvancedPaginationResponse();
	}

	/**
	 * Create an instance of {@link ModifyInvestigationResponse }
	 * 
	 */
	public ModifyInvestigationResponse createModifyInvestigationResponse() {
		return new ModifyInvestigationResponse();
	}

	/**
	 * Create an instance of {@link CheckDatafileDownloadAccess }
	 * 
	 */
	public CheckDatafileDownloadAccess createCheckDatafileDownloadAccess() {
		return new CheckDatafileDownloadAccess();
	}

	/**
	 * Create an instance of {@link ListDatafileFormatsResponse }
	 * 
	 */
	public ListDatafileFormatsResponse createListDatafileFormatsResponse() {
		return new ListDatafileFormatsResponse();
	}

	/**
	 * Create an instance of {@link FacilityCycle }
	 * 
	 */
	public FacilityCycle createFacilityCycle() {
		return new FacilityCycle();
	}

	/**
	 * Create an instance of {@link SearchByRunNumberPagination }
	 * 
	 */
	public SearchByRunNumberPagination createSearchByRunNumberPagination() {
		return new SearchByRunNumberPagination();
	}

	/**
	 * Create an instance of {@link GetDatafiles }
	 * 
	 */
	public GetDatafiles createGetDatafiles() {
		return new GetDatafiles();
	}

	/**
	 * Create an instance of {@link DeleteDataSet }
	 * 
	 */
	public DeleteDataSet createDeleteDataSet() {
		return new DeleteDataSet();
	}

	/**
	 * Create an instance of {@link LogoutResponse }
	 * 
	 */
	public LogoutResponse createLogoutResponse() {
		return new LogoutResponse();
	}

	/**
	 * Create an instance of {@link SessionException }
	 * 
	 */
	public SessionException createSessionException() {
		return new SessionException();
	}

	/**
	 * Create an instance of {@link Shift }
	 * 
	 */
	public Shift createShift() {
		return new Shift();
	}

	/**
	 * Create an instance of {@link DeleteSampleParameter }
	 * 
	 */
	public DeleteSampleParameter createDeleteSampleParameter() {
		return new DeleteSampleParameter();
	}

	/**
	 * Create an instance of {@link AddDataFileParameterResponse }
	 * 
	 */
	public AddDataFileParameterResponse createAddDataFileParameterResponse() {
		return new AddDataFileParameterResponse();
	}

	/**
	 * Create an instance of {@link SearchByAdvanced }
	 * 
	 */
	public SearchByAdvanced createSearchByAdvanced() {
		return new SearchByAdvanced();
	}

	/**
	 * Create an instance of {@link DeleteInvestigatorResponse }
	 * 
	 */
	public DeleteInvestigatorResponse createDeleteInvestigatorResponse() {
		return new DeleteInvestigatorResponse();
	}

	/**
	 * Create an instance of {@link DeleteInvestigation }
	 * 
	 */
	public DeleteInvestigation createDeleteInvestigation() {
		return new DeleteInvestigation();
	}

	/**
	 * Create an instance of {@link UpdateAuthorisationResponse }
	 * 
	 */
	public UpdateAuthorisationResponse createUpdateAuthorisationResponse() {
		return new UpdateAuthorisationResponse();
	}

	/**
	 * Create an instance of {@link InvestigatorPK }
	 * 
	 */
	public InvestigatorPK createInvestigatorPK() {
		return new InvestigatorPK();
	}

	/**
	 * Create an instance of {@link GetAuthorisations }
	 * 
	 */
	public GetAuthorisations createGetAuthorisations() {
		return new GetAuthorisations();
	}

	/**
	 * Create an instance of {@link GetDatafilesResponse }
	 * 
	 */
	public GetDatafilesResponse createGetDatafilesResponse() {
		return new GetDatafilesResponse();
	}

	/**
	 * Create an instance of {@link CheckDatasetDownloadAccess }
	 * 
	 */
	public CheckDatasetDownloadAccess createCheckDatasetDownloadAccess() {
		return new CheckDatasetDownloadAccess();
	}

	/**
	 * Create an instance of {@link RemoveDataFileParameterResponse }
	 * 
	 */
	public RemoveDataFileParameterResponse createRemoveDataFileParameterResponse() {
		return new RemoveDataFileParameterResponse();
	}

	/**
	 * Create an instance of {@link GetInvestigationIncludesResponse }
	 * 
	 */
	public GetInvestigationIncludesResponse createGetInvestigationIncludesResponse() {
		return new GetInvestigationIncludesResponse();
	}

	/**
	 * Create an instance of {@link RemoveInvestigatorResponse }
	 * 
	 */
	public RemoveInvestigatorResponse createRemoveInvestigatorResponse() {
		return new RemoveInvestigatorResponse();
	}

	/**
	 * Create an instance of {@link ModifySample }
	 * 
	 */
	public ModifySample createModifySample() {
		return new ModifySample();
	}

	/**
	 * Create an instance of {@link DeleteDataFileParameter }
	 * 
	 */
	public DeleteDataFileParameter createDeleteDataFileParameter() {
		return new DeleteDataFileParameter();
	}

	/**
	 * Create an instance of {@link RemoveInvestigator }
	 * 
	 */
	public RemoveInvestigator createRemoveInvestigator() {
		return new RemoveInvestigator();
	}

	/**
	 * Create an instance of {@link SearchByRunNumberResponse }
	 * 
	 */
	public SearchByRunNumberResponse createSearchByRunNumberResponse() {
		return new SearchByRunNumberResponse();
	}

	/**
	 * Create an instance of {@link SearchByUserIDPaginationResponse }
	 * 
	 */
	public SearchByUserIDPaginationResponse createSearchByUserIDPaginationResponse() {
		return new SearchByUserIDPaginationResponse();
	}

	/**
	 * Create an instance of {@link ModifyDataFile }
	 * 
	 */
	public ModifyDataFile createModifyDataFile() {
		return new ModifyDataFile();
	}

	/**
	 * Create an instance of {@link ListDatasetStatusResponse }
	 * 
	 */
	public ListDatasetStatusResponse createListDatasetStatusResponse() {
		return new ListDatasetStatusResponse();
	}

	/**
	 * Create an instance of {@link SearchByRunNumber }
	 * 
	 */
	public SearchByRunNumber createSearchByRunNumber() {
		return new SearchByRunNumber();
	}

	/**
	 * Create an instance of {@link AddDataSetParameterResponse }
	 * 
	 */
	public AddDataSetParameterResponse createAddDataSetParameterResponse() {
		return new AddDataSetParameterResponse();
	}

	/**
	 * Create an instance of {@link DatasetParameter }
	 * 
	 */
	public DatasetParameter createDatasetParameter() {
		return new DatasetParameter();
	}

	/**
	 * Create an instance of {@link RemovePublicationResponse }
	 * 
	 */
	public RemovePublicationResponse createRemovePublicationResponse() {
		return new RemovePublicationResponse();
	}

	/**
	 * Create an instance of {@link ModifyDataSetResponse }
	 * 
	 */
	public ModifyDataSetResponse createModifyDataSetResponse() {
		return new ModifyDataSetResponse();
	}

	/**
	 * Create an instance of {@link GetInvestigation }
	 * 
	 */
	public GetInvestigation createGetInvestigation() {
		return new GetInvestigation();
	}

	/**
	 * Create an instance of {@link DownloadDatafile }
	 * 
	 */
	public DownloadDatafile createDownloadDatafile() {
		return new DownloadDatafile();
	}

	/**
	 * Create an instance of {@link GetKeywordsForUserResponse }
	 * 
	 */
	public GetKeywordsForUserResponse createGetKeywordsForUserResponse() {
		return new GetKeywordsForUserResponse();
	}

	/**
	 * Create an instance of {@link SearchByRunNumberPaginationResponse }
	 * 
	 */
	public SearchByRunNumberPaginationResponse createSearchByRunNumberPaginationResponse() {
		return new SearchByRunNumberPaginationResponse();
	}

	/**
	 * Create an instance of {@link RemoveDataSet }
	 * 
	 */
	public RemoveDataSet createRemoveDataSet() {
		return new RemoveDataSet();
	}

	/**
	 * Create an instance of {@link ListRolesResponse }
	 * 
	 */
	public ListRolesResponse createListRolesResponse() {
		return new ListRolesResponse();
	}

	/**
	 * Create an instance of {@link AddPublication }
	 * 
	 */
	public AddPublication createAddPublication() {
		return new AddPublication();
	}

	/**
	 * Create an instance of {@link SearchByKeywordsResponse }
	 * 
	 */
	public SearchByKeywordsResponse createSearchByKeywordsResponse() {
		return new SearchByKeywordsResponse();
	}

	/**
	 * Create an instance of {@link IcatRole }
	 * 
	 */
	public IcatRole createIcatRole() {
		return new IcatRole();
	}

	/**
	 * Create an instance of {@link LoginLifetimeResponse }
	 * 
	 */
	public LoginLifetimeResponse createLoginLifetimeResponse() {
		return new LoginLifetimeResponse();
	}

	/**
	 * Create an instance of {@link SetDataSetSampleResponse }
	 * 
	 */
	public SetDataSetSampleResponse createSetDataSetSampleResponse() {
		return new SetDataSetSampleResponse();
	}

	/**
	 * Create an instance of {@link GetMyInvestigationsResponse }
	 * 
	 */
	public GetMyInvestigationsResponse createGetMyInvestigationsResponse() {
		return new GetMyInvestigationsResponse();
	}

	/**
	 * Create an instance of {@link IngestMetadataResponse }
	 * 
	 */
	public IngestMetadataResponse createIngestMetadataResponse() {
		return new IngestMetadataResponse();
	}

	/**
	 * Create an instance of {@link GetInvestigationResponse }
	 * 
	 */
	public GetInvestigationResponse createGetInvestigationResponse() {
		return new GetInvestigationResponse();
	}

	/**
	 * Create an instance of {@link DeletePublication }
	 * 
	 */
	public DeletePublication createDeletePublication() {
		return new DeletePublication();
	}

	/**
	 * Create an instance of {@link SearchByUserIDPagination }
	 * 
	 */
	public SearchByUserIDPagination createSearchByUserIDPagination() {
		return new SearchByUserIDPagination();
	}

	/**
	 * Create an instance of {@link CreateDataFile }
	 * 
	 */
	public CreateDataFile createCreateDataFile() {
		return new CreateDataFile();
	}

	/**
	 * Create an instance of {@link SampleParameterPK }
	 * 
	 */
	public SampleParameterPK createSampleParameterPK() {
		return new SampleParameterPK();
	}

	/**
	 * Create an instance of {@link GetKeywordsForUserStartWithMax }
	 * 
	 */
	public GetKeywordsForUserStartWithMax createGetKeywordsForUserStartWithMax() {
		return new GetKeywordsForUserStartWithMax();
	}

	/**
	 * Create an instance of {@link RemoveDataSetParameter }
	 * 
	 */
	public RemoveDataSetParameter createRemoveDataSetParameter() {
		return new RemoveDataSetParameter();
	}

	/**
	 * Create an instance of {@link CreateDataFileResponse }
	 * 
	 */
	public CreateDataFileResponse createCreateDataFileResponse() {
		return new CreateDataFileResponse();
	}

	/**
	 * Create an instance of {@link SearchSamplesBySampleName }
	 * 
	 */
	public SearchSamplesBySampleName createSearchSamplesBySampleName() {
		return new SearchSamplesBySampleName();
	}

	/**
	 * Create an instance of {@link AddSampleParameter }
	 * 
	 */
	public AddSampleParameter createAddSampleParameter() {
		return new AddSampleParameter();
	}

	/**
	 * Create an instance of {@link GetDatafileResponse }
	 * 
	 */
	public GetDatafileResponse createGetDatafileResponse() {
		return new GetDatafileResponse();
	}

	/**
	 * Create an instance of {@link ListInstruments }
	 * 
	 */
	public ListInstruments createListInstruments() {
		return new ListInstruments();
	}

	/**
	 * Create an instance of {@link ModifyDataFileParameterResponse }
	 * 
	 */
	public ModifyDataFileParameterResponse createModifyDataFileParameterResponse() {
		return new ModifyDataFileParameterResponse();
	}

	/**
	 * Create an instance of {@link Login }
	 * 
	 */
	public Login createLogin() {
		return new Login();
	}

	/**
	 * Create an instance of {@link RemoveAuthorisationResponse }
	 * 
	 */
	public RemoveAuthorisationResponse createRemoveAuthorisationResponse() {
		return new RemoveAuthorisationResponse();
	}

	/**
	 * Create an instance of {@link SearchByUserSurnamePaginationResponse }
	 * 
	 */
	public SearchByUserSurnamePaginationResponse createSearchByUserSurnamePaginationResponse() {
		return new SearchByUserSurnamePaginationResponse();
	}

	/**
	 * Create an instance of {@link ListInstrumentsResponse }
	 * 
	 */
	public ListInstrumentsResponse createListInstrumentsResponse() {
		return new ListInstrumentsResponse();
	}

	/**
	 * Create an instance of {@link DeleteKeywordResponse }
	 * 
	 */
	public DeleteKeywordResponse createDeleteKeywordResponse() {
		return new DeleteKeywordResponse();
	}

	/**
	 * Create an instance of {@link SetDataSetSample }
	 * 
	 */
	public SetDataSetSample createSetDataSetSample() {
		return new SetDataSetSample();
	}

	/**
	 * Create an instance of {@link GetAllKeywordsResponse }
	 * 
	 */
	public GetAllKeywordsResponse createGetAllKeywordsResponse() {
		return new GetAllKeywordsResponse();
	}

	/**
	 * Create an instance of {@link UpdateAuthorisation }
	 * 
	 */
	public UpdateAuthorisation createUpdateAuthorisation() {
		return new UpdateAuthorisation();
	}

	/**
	 * Create an instance of {@link RemoveKeywordResponse }
	 * 
	 */
	public RemoveKeywordResponse createRemoveKeywordResponse() {
		return new RemoveKeywordResponse();
	}

	/**
	 * Create an instance of {@link SampleParameter }
	 * 
	 */
	public SampleParameter createSampleParameter() {
		return new SampleParameter();
	}

	/**
	 * Create an instance of {@link DeleteSampleParameterResponse }
	 * 
	 */
	public DeleteSampleParameterResponse createDeleteSampleParameterResponse() {
		return new DeleteSampleParameterResponse();
	}

	/**
	 * Create an instance of {@link DownloadDataset }
	 * 
	 */
	public DownloadDataset createDownloadDataset() {
		return new DownloadDataset();
	}

	/**
	 * Create an instance of {@link AdvancedSearchDetails }
	 * 
	 */
	public AdvancedSearchDetails createAdvancedSearchDetails() {
		return new AdvancedSearchDetails();
	}

	/**
	 * Create an instance of {@link DownloadDatafileResponse }
	 * 
	 */
	public DownloadDatafileResponse createDownloadDatafileResponse() {
		return new DownloadDatafileResponse();
	}

	/**
	 * Create an instance of {@link IcatAuthorisation }
	 * 
	 */
	public IcatAuthorisation createIcatAuthorisation() {
		return new IcatAuthorisation();
	}

	/**
	 * Create an instance of {@link DownloadDatafiles }
	 * 
	 */
	public DownloadDatafiles createDownloadDatafiles() {
		return new DownloadDatafiles();
	}

	/**
	 * Create an instance of {@link ListDatafileFormats }
	 * 
	 */
	public ListDatafileFormats createListDatafileFormats() {
		return new ListDatafileFormats();
	}

	/**
	 * Create an instance of {@link AddDataSetParametersResponse }
	 * 
	 */
	public AddDataSetParametersResponse createAddDataSetParametersResponse() {
		return new AddDataSetParametersResponse();
	}

	/**
	 * Create an instance of {@link AddSampleResponse }
	 * 
	 */
	public AddSampleResponse createAddSampleResponse() {
		return new AddSampleResponse();
	}

	/**
	 * Create an instance of {@link ListParametersResponse }
	 * 
	 */
	public ListParametersResponse createListParametersResponse() {
		return new ListParametersResponse();
	}

	/**
	 * Create an instance of {@link DeleteAuthorisation }
	 * 
	 */
	public DeleteAuthorisation createDeleteAuthorisation() {
		return new DeleteAuthorisation();
	}

	/**
	 * Create an instance of {@link DatasetParameterPK }
	 * 
	 */
	public DatasetParameterPK createDatasetParameterPK() {
		return new DatasetParameterPK();
	}

	/**
	 * Create an instance of {@link ListInvestigationTypes }
	 * 
	 */
	public ListInvestigationTypes createListInvestigationTypes() {
		return new ListInvestigationTypes();
	}

	/**
	 * Create an instance of {@link ModifyDataFileResponse }
	 * 
	 */
	public ModifyDataFileResponse createModifyDataFileResponse() {
		return new ModifyDataFileResponse();
	}

	/**
	 * Create an instance of {@link AddPublicationResponse }
	 * 
	 */
	public AddPublicationResponse createAddPublicationResponse() {
		return new AddPublicationResponse();
	}

	/**
	 * Create an instance of {@link RemoveInvestigation }
	 * 
	 */
	public RemoveInvestigation createRemoveInvestigation() {
		return new RemoveInvestigation();
	}

	/**
	 * Create an instance of {@link GetInvestigationIncludes }
	 * 
	 */
	public GetInvestigationIncludes createGetInvestigationIncludes() {
		return new GetInvestigationIncludes();
	}

	/**
	 * Create an instance of {@link CreateInvestigationResponse }
	 * 
	 */
	public CreateInvestigationResponse createCreateInvestigationResponse() {
		return new CreateInvestigationResponse();
	}

	/**
	 * Create an instance of {@link SearchByKeywordsAllResponse }
	 * 
	 */
	public SearchByKeywordsAllResponse createSearchByKeywordsAllResponse() {
		return new SearchByKeywordsAllResponse();
	}

	/**
	 * Create an instance of {@link DeleteDataFile }
	 * 
	 */
	public DeleteDataFile createDeleteDataFile() {
		return new DeleteDataFile();
	}

	/**
	 * Create an instance of {@link DatafileParameter }
	 * 
	 */
	public DatafileParameter createDatafileParameter() {
		return new DatafileParameter();
	}

	/**
	 * Create an instance of {@link GetKeywordsForUserTypeResponse }
	 * 
	 */
	public GetKeywordsForUserTypeResponse createGetKeywordsForUserTypeResponse() {
		return new GetKeywordsForUserTypeResponse();
	}

	/**
	 * Create an instance of {@link Investigation }
	 * 
	 */
	public Investigation createInvestigation() {
		return new Investigation();
	}

	/**
	 * Create an instance of {@link AddSampleParameterResponse }
	 * 
	 */
	public AddSampleParameterResponse createAddSampleParameterResponse() {
		return new AddSampleParameterResponse();
	}

	/**
	 * Create an instance of {@link GetDatasetIncludes }
	 * 
	 */
	public GetDatasetIncludes createGetDatasetIncludes() {
		return new GetDatasetIncludes();
	}

	/**
	 * Create an instance of {@link ParameterPK }
	 * 
	 */
	public ParameterPK createParameterPK() {
		return new ParameterPK();
	}

	/**
	 * Create an instance of {@link Dataset }
	 * 
	 */
	public Dataset createDataset() {
		return new Dataset();
	}

	/**
	 * Create an instance of {@link GetDatasetIncludesResponse }
	 * 
	 */
	public GetDatasetIncludesResponse createGetDatasetIncludesResponse() {
		return new GetDatasetIncludesResponse();
	}

	/**
	 * Create an instance of {@link DownloadDatafilesResponse }
	 * 
	 */
	public DownloadDatafilesResponse createDownloadDatafilesResponse() {
		return new DownloadDatafilesResponse();
	}

	/**
	 * Create an instance of {@link DeleteKeyword }
	 * 
	 */
	public DeleteKeyword createDeleteKeyword() {
		return new DeleteKeyword();
	}

	/**
	 * Create an instance of {@link CreateDataSet }
	 * 
	 */
	public CreateDataSet createCreateDataSet() {
		return new CreateDataSet();
	}

	/**
	 * Create an instance of {@link GetKeywordsForUserMax }
	 * 
	 */
	public GetKeywordsForUserMax createGetKeywordsForUserMax() {
		return new GetKeywordsForUserMax();
	}

	/**
	 * Create an instance of {@link KeywordPK }
	 * 
	 */
	public KeywordPK createKeywordPK() {
		return new KeywordPK();
	}

	/**
	 * Create an instance of {@link RemoveDataFile }
	 * 
	 */
	public RemoveDataFile createRemoveDataFile() {
		return new RemoveDataFile();
	}

	/**
	 * Create an instance of {@link RemoveKeyword }
	 * 
	 */
	public RemoveKeyword createRemoveKeyword() {
		return new RemoveKeyword();
	}

	/**
	 * Create an instance of {@link Sample }
	 * 
	 */
	public Sample createSample() {
		return new Sample();
	}

	/**
	 * Create an instance of {@link DatafileFormatPK }
	 * 
	 */
	public DatafileFormatPK createDatafileFormatPK() {
		return new DatafileFormatPK();
	}

	/**
	 * Create an instance of {@link AddAuthorisationResponse }
	 * 
	 */
	public AddAuthorisationResponse createAddAuthorisationResponse() {
		return new AddAuthorisationResponse();
	}

	/**
	 * Create an instance of {@link ListDatasetTypes }
	 * 
	 */
	public ListDatasetTypes createListDatasetTypes() {
		return new ListDatasetTypes();
	}

	/**
	 * Create an instance of {@link GetDatasetsResponse }
	 * 
	 */
	public GetDatasetsResponse createGetDatasetsResponse() {
		return new GetDatasetsResponse();
	}

	/**
	 * Create an instance of {@link SearchByKeywords }
	 * 
	 */
	public SearchByKeywords createSearchByKeywords() {
		return new SearchByKeywords();
	}

	/**
	 * Create an instance of {@link AddKeyword }
	 * 
	 */
	public AddKeyword createAddKeyword() {
		return new AddKeyword();
	}

	/**
	 * Create an instance of {@link ModifyInvestigatorResponse }
	 * 
	 */
	public ModifyInvestigatorResponse createModifyInvestigatorResponse() {
		return new ModifyInvestigatorResponse();
	}

	/**
	 * Create an instance of {@link CreateDataSetResponse }
	 * 
	 */
	public CreateDataSetResponse createCreateDataSetResponse() {
		return new CreateDataSetResponse();
	}

	/**
	 * Create an instance of {@link LoginResponse }
	 * 
	 */
	public LoginResponse createLoginResponse() {
		return new LoginResponse();
	}

	/**
	 * Create an instance of {@link ListInvestigationTypesResponse }
	 * 
	 */
	public ListInvestigationTypesResponse createListInvestigationTypesResponse() {
		return new ListInvestigationTypesResponse();
	}

	/**
	 * Create an instance of {@link ValidationException }
	 * 
	 */
	public ValidationException createValidationException() {
		return new ValidationException();
	}

	/**
	 * Create an instance of {@link CreateDataFilesResponse }
	 * 
	 */
	public CreateDataFilesResponse createCreateDataFilesResponse() {
		return new CreateDataFilesResponse();
	}

	/**
	 * Create an instance of {@link DeleteDataFileResponse }
	 * 
	 */
	public DeleteDataFileResponse createDeleteDataFileResponse() {
		return new DeleteDataFileResponse();
	}

	/**
	 * Create an instance of {@link GetMyInvestigations }
	 * 
	 */
	public GetMyInvestigations createGetMyInvestigations() {
		return new GetMyInvestigations();
	}

	/**
	 * Create an instance of {@link RemoveDataFileResponse }
	 * 
	 */
	public RemoveDataFileResponse createRemoveDataFileResponse() {
		return new RemoveDataFileResponse();
	}

	/**
	 * Create an instance of {@link DeleteSampleResponse }
	 * 
	 */
	public DeleteSampleResponse createDeleteSampleResponse() {
		return new DeleteSampleResponse();
	}

	/**
	 * Create an instance of {@link RelatedDatafiles }
	 * 
	 */
	public RelatedDatafiles createRelatedDatafiles() {
		return new RelatedDatafiles();
	}

	/**
	 * Create an instance of {@link RemoveSampleResponse }
	 * 
	 */
	public RemoveSampleResponse createRemoveSampleResponse() {
		return new RemoveSampleResponse();
	}

	/**
	 * Create an instance of {@link Keyword }
	 * 
	 */
	public Keyword createKeyword() {
		return new Keyword();
	}

	/**
	 * Create an instance of {@link SearchByUserSurname }
	 * 
	 */
	public SearchByUserSurname createSearchByUserSurname() {
		return new SearchByUserSurname();
	}

	/**
	 * Create an instance of {@link Datafile }
	 * 
	 */
	public Datafile createDatafile() {
		return new Datafile();
	}

	/**
	 * Create an instance of {@link ModifyInvestigation }
	 * 
	 */
	public ModifyInvestigation createModifyInvestigation() {
		return new ModifyInvestigation();
	}

	/**
	 * Create an instance of {@link DownloadDatasetResponse }
	 * 
	 */
	public DownloadDatasetResponse createDownloadDatasetResponse() {
		return new DownloadDatasetResponse();
	}

	/**
	 * Create an instance of {@link DeleteInvestigator }
	 * 
	 */
	public DeleteInvestigator createDeleteInvestigator() {
		return new DeleteInvestigator();
	}

	/**
	 * Create an instance of {@link SearchByUserSurnamePagination }
	 * 
	 */
	public SearchByUserSurnamePagination createSearchByUserSurnamePagination() {
		return new SearchByUserSurnamePagination();
	}

	/**
	 * Create an instance of {@link DeleteDataSetResponse }
	 * 
	 */
	public DeleteDataSetResponse createDeleteDataSetResponse() {
		return new DeleteDataSetResponse();
	}

	/**
	 * Create an instance of {@link FacilityUser }
	 * 
	 */
	public FacilityUser createFacilityUser() {
		return new FacilityUser();
	}

	/**
	 * Create an instance of {@link SearchByAdvancedPagination }
	 * 
	 */
	public SearchByAdvancedPagination createSearchByAdvancedPagination() {
		return new SearchByAdvancedPagination();
	}

	/**
	 * Create an instance of {@link AddInvestigator }
	 * 
	 */
	public AddInvestigator createAddInvestigator() {
		return new AddInvestigator();
	}

	/**
	 * Create an instance of {@link CheckDatasetDownloadAccessResponse }
	 * 
	 */
	public CheckDatasetDownloadAccessResponse createCheckDatasetDownloadAccessResponse() {
		return new CheckDatasetDownloadAccessResponse();
	}

	/**
	 * Create an instance of {@link SearchDatasetsBySampleResponse }
	 * 
	 */
	public SearchDatasetsBySampleResponse createSearchDatasetsBySampleResponse() {
		return new SearchDatasetsBySampleResponse();
	}

	/**
	 * Create an instance of {@link ModifyPublicationResponse }
	 * 
	 */
	public ModifyPublicationResponse createModifyPublicationResponse() {
		return new ModifyPublicationResponse();
	}

	/**
	 * Create an instance of {@link RemoveDataSetResponse }
	 * 
	 */
	public RemoveDataSetResponse createRemoveDataSetResponse() {
		return new RemoveDataSetResponse();
	}

	/**
	 * Create an instance of {@link RemoveSample }
	 * 
	 */
	public RemoveSample createRemoveSample() {
		return new RemoveSample();
	}

	/**
	 * Create an instance of {@link ModifyInvestigator }
	 * 
	 */
	public ModifyInvestigator createModifyInvestigator() {
		return new ModifyInvestigator();
	}

	/**
	 * Create an instance of {@link CreateDataFiles }
	 * 
	 */
	public CreateDataFiles createCreateDataFiles() {
		return new CreateDataFiles();
	}

	/**
	 * Create an instance of {@link GetAllKeywords }
	 * 
	 */
	public GetAllKeywords createGetAllKeywords() {
		return new GetAllKeywords();
	}

	/**
	 * Create an instance of {@link CreateInvestigation }
	 * 
	 */
	public CreateInvestigation createCreateInvestigation() {
		return new CreateInvestigation();
	}

	/**
	 * Create an instance of {@link ModifySampleParameterResponse }
	 * 
	 */
	public ModifySampleParameterResponse createModifySampleParameterResponse() {
		return new ModifySampleParameterResponse();
	}

	/**
	 * Create an instance of {@link ListDatasetStatus }
	 * 
	 */
	public ListDatasetStatus createListDatasetStatus() {
		return new ListDatasetStatus();
	}

	/**
	 * Create an instance of {@link RemoveDataSetParameterResponse }
	 * 
	 */
	public RemoveDataSetParameterResponse createRemoveDataSetParameterResponse() {
		return new RemoveDataSetParameterResponse();
	}

	/**
	 * Create an instance of {@link AddDataFileParameter }
	 * 
	 */
	public AddDataFileParameter createAddDataFileParameter() {
		return new AddDataFileParameter();
	}

	/**
	 * Create an instance of {@link AddKeywordResponse }
	 * 
	 */
	public AddKeywordResponse createAddKeywordResponse() {
		return new AddKeywordResponse();
	}

	/**
	 * Create an instance of {@link GetMyInvestigationsIncludes }
	 * 
	 */
	public GetMyInvestigationsIncludes createGetMyInvestigationsIncludes() {
		return new GetMyInvestigationsIncludes();
	}

	/**
	 * Create an instance of {@link GetAuthorisationsResponse }
	 * 
	 */
	public GetAuthorisationsResponse createGetAuthorisationsResponse() {
		return new GetAuthorisationsResponse();
	}

	/**
	 * Create an instance of {@link DatafileFormat }
	 * 
	 */
	public DatafileFormat createDatafileFormat() {
		return new DatafileFormat();
	}

	/**
	 * Create an instance of {@link LoginLifetime }
	 * 
	 */
	public LoginLifetime createLoginLifetime() {
		return new LoginLifetime();
	}

	/**
	 * Create an instance of {@link RemoveInvestigationResponse }
	 * 
	 */
	public RemoveInvestigationResponse createRemoveInvestigationResponse() {
		return new RemoveInvestigationResponse();
	}

	/**
	 * Create an instance of {@link Investigator }
	 * 
	 */
	public Investigator createInvestigator() {
		return new Investigator();
	}

	/**
	 * Create an instance of {@link AddDataSetParameters }
	 * 
	 */
	public AddDataSetParameters createAddDataSetParameters() {
		return new AddDataSetParameters();
	}

	/**
	 * Create an instance of {@link RemoveAuthorisation }
	 * 
	 */
	public RemoveAuthorisation createRemoveAuthorisation() {
		return new RemoveAuthorisation();
	}

	/**
	 * Create an instance of {@link SearchByKeywordsAll }
	 * 
	 */
	public SearchByKeywordsAll createSearchByKeywordsAll() {
		return new SearchByKeywordsAll();
	}

	/**
	 * Create an instance of {@link ListRoles }
	 * 
	 */
	public ListRoles createListRoles() {
		return new ListRoles();
	}

	/**
	 * Create an instance of {@link DeletePublicationResponse }
	 * 
	 */
	public DeletePublicationResponse createDeletePublicationResponse() {
		return new DeletePublicationResponse();
	}

	/**
	 * Create an instance of {@link AddDataSetParameter }
	 * 
	 */
	public AddDataSetParameter createAddDataSetParameter() {
		return new AddDataSetParameter();
	}

	/**
	 * Create an instance of {@link DeleteDataSetParameterResponse }
	 * 
	 */
	public DeleteDataSetParameterResponse createDeleteDataSetParameterResponse() {
		return new DeleteDataSetParameterResponse();
	}

	/**
	 * Create an instance of {@link DatafileParameterPK }
	 * 
	 */
	public DatafileParameterPK createDatafileParameterPK() {
		return new DatafileParameterPK();
	}

	/**
	 * Create an instance of {@link RemovePublication }
	 * 
	 */
	public RemovePublication createRemovePublication() {
		return new RemovePublication();
	}

	/**
	 * Create an instance of {@link IngestMetadata }
	 * 
	 */
	public IngestMetadata createIngestMetadata() {
		return new IngestMetadata();
	}

	/**
	 * Create an instance of {@link AddAuthorisation }
	 * 
	 */
	public AddAuthorisation createAddAuthorisation() {
		return new AddAuthorisation();
	}

	/**
	 * Create an instance of {@link GetKeywordsForUserMaxResponse }
	 * 
	 */
	public GetKeywordsForUserMaxResponse createGetKeywordsForUserMaxResponse() {
		return new GetKeywordsForUserMaxResponse();
	}

	/**
	 * Create an instance of {@link GetDatasetResponse }
	 * 
	 */
	public GetDatasetResponse createGetDatasetResponse() {
		return new GetDatasetResponse();
	}

	/**
	 * Create an instance of {@link CreateDataSets }
	 * 
	 */
	public CreateDataSets createCreateDataSets() {
		return new CreateDataSets();
	}

	/**
	 * Create an instance of {@link GetKeywordsForUser }
	 * 
	 */
	public GetKeywordsForUser createGetKeywordsForUser() {
		return new GetKeywordsForUser();
	}

	/**
	 * Create an instance of {@link GetDatafile }
	 * 
	 */
	public GetDatafile createGetDatafile() {
		return new GetDatafile();
	}

	/**
	 * Create an instance of {@link GetDataset }
	 * 
	 */
	public GetDataset createGetDataset() {
		return new GetDataset();
	}

	/**
	 * Create an instance of {@link RemoveDataFileParameter }
	 * 
	 */
	public RemoveDataFileParameter createRemoveDataFileParameter() {
		return new RemoveDataFileParameter();
	}

	/**
	 * Create an instance of {@link RemoveSampleParameter }
	 * 
	 */
	public RemoveSampleParameter createRemoveSampleParameter() {
		return new RemoveSampleParameter();
	}

	/**
	 * Create an instance of {@link GetMyInvestigationsIncludesPagination }
	 * 
	 */
	public GetMyInvestigationsIncludesPagination createGetMyInvestigationsIncludesPagination() {
		return new GetMyInvestigationsIncludesPagination();
	}

	/**
	 * Create an instance of {@link ListDatasetTypesResponse }
	 * 
	 */
	public ListDatasetTypesResponse createListDatasetTypesResponse() {
		return new ListDatasetTypesResponse();
	}

	/**
	 * Create an instance of {@link AddDataFileParameters }
	 * 
	 */
	public AddDataFileParameters createAddDataFileParameters() {
		return new AddDataFileParameters();
	}

	/**
	 * Create an instance of {@link ModifyPublication }
	 * 
	 */
	public ModifyPublication createModifyPublication() {
		return new ModifyPublication();
	}

	/**
	 * Create an instance of {@link ModifyDataFileParameter }
	 * 
	 */
	public ModifyDataFileParameter createModifyDataFileParameter() {
		return new ModifyDataFileParameter();
	}

	/**
	 * Create an instance of {@link AddDataFileParametersResponse }
	 * 
	 */
	public AddDataFileParametersResponse createAddDataFileParametersResponse() {
		return new AddDataFileParametersResponse();
	}

	/**
	 * Create an instance of {@link GetKeywordsForUserStartWithMaxResponse }
	 * 
	 */
	public GetKeywordsForUserStartWithMaxResponse createGetKeywordsForUserStartWithMaxResponse() {
		return new GetKeywordsForUserStartWithMaxResponse();
	}

	/**
	 * Create an instance of {@link NoSuchObjectFoundException }
	 * 
	 */
	public NoSuchObjectFoundException createNoSuchObjectFoundException() {
		return new NoSuchObjectFoundException();
	}

	/**
	 * Create an instance of {@link ModifyDataSetParameter }
	 * 
	 */
	public ModifyDataSetParameter createModifyDataSetParameter() {
		return new ModifyDataSetParameter();
	}

	/**
	 * Create an instance of {@link ModifySampleResponse }
	 * 
	 */
	public ModifySampleResponse createModifySampleResponse() {
		return new ModifySampleResponse();
	}

	/**
	 * Create an instance of {@link DeleteAuthorisationResponse }
	 * 
	 */
	public DeleteAuthorisationResponse createDeleteAuthorisationResponse() {
		return new DeleteAuthorisationResponse();
	}

	/**
	 * Create an instance of {@link CreateDataSetsResponse }
	 * 
	 */
	public CreateDataSetsResponse createCreateDataSetsResponse() {
		return new CreateDataSetsResponse();
	}

	/**
	 * Create an instance of {@link DeleteInvestigationResponse }
	 * 
	 */
	public DeleteInvestigationResponse createDeleteInvestigationResponse() {
		return new DeleteInvestigationResponse();
	}

	/**
	 * Create an instance of {@link DownloadInfo }
	 * 
	 */
	public DownloadInfo createDownloadInfo() {
		return new DownloadInfo();
	}

	/**
	 * Create an instance of {@link DeleteSample }
	 * 
	 */
	public DeleteSample createDeleteSample() {
		return new DeleteSample();
	}

	/**
	 * Create an instance of {@link GetInvestigationsIncludes }
	 * 
	 */
	public GetInvestigationsIncludes createGetInvestigationsIncludes() {
		return new GetInvestigationsIncludes();
	}

	/**
	 * Create an instance of
	 * {@link GetMyInvestigationsIncludesPaginationResponse }
	 * 
	 */
	public GetMyInvestigationsIncludesPaginationResponse createGetMyInvestigationsIncludesPaginationResponse() {
		return new GetMyInvestigationsIncludesPaginationResponse();
	}

	/**
	 * Create an instance of {@link ICATAPIException }
	 * 
	 */
	public ICATAPIException createICATAPIException() {
		return new ICATAPIException();
	}

	/**
	 * Create an instance of {@link GetMyInvestigationsIncludesResponse }
	 * 
	 */
	public GetMyInvestigationsIncludesResponse createGetMyInvestigationsIncludesResponse() {
		return new GetMyInvestigationsIncludesResponse();
	}

	/**
	 * Create an instance of {@link GetInvestigationsIncludesResponse }
	 * 
	 */
	public GetInvestigationsIncludesResponse createGetInvestigationsIncludesResponse() {
		return new GetInvestigationsIncludesResponse();
	}

	/**
	 * Create an instance of {@link ListParameters }
	 * 
	 */
	public ListParameters createListParameters() {
		return new ListParameters();
	}

	/**
	 * Create an instance of {@link DeleteDataSetParameter }
	 * 
	 */
	public DeleteDataSetParameter createDeleteDataSetParameter() {
		return new DeleteDataSetParameter();
	}

	/**
	 * Create an instance of {@link SearchByUserIDResponse }
	 * 
	 */
	public SearchByUserIDResponse createSearchByUserIDResponse() {
		return new SearchByUserIDResponse();
	}

	/**
	 * Create an instance of {@link SearchDatasetsBySample }
	 * 
	 */
	public SearchDatasetsBySample createSearchDatasetsBySample() {
		return new SearchDatasetsBySample();
	}

	/**
	 * Create an instance of {@link AddSample }
	 * 
	 */
	public AddSample createAddSample() {
		return new AddSample();
	}

	/**
	 * Create an instance of {@link RelatedDatafilesPK }
	 * 
	 */
	public RelatedDatafilesPK createRelatedDatafilesPK() {
		return new RelatedDatafilesPK();
	}

	/**
	 * Create an instance of {@link ShiftPK }
	 * 
	 */
	public ShiftPK createShiftPK() {
		return new ShiftPK();
	}

	/**
	 * Create an instance of {@link ModifyDataSet }
	 * 
	 */
	public ModifyDataSet createModifyDataSet() {
		return new ModifyDataSet();
	}

	/**
	 * Create an instance of {@link RemoveSampleParameterResponse }
	 * 
	 */
	public RemoveSampleParameterResponse createRemoveSampleParameterResponse() {
		return new RemoveSampleParameterResponse();
	}

	/**
	 * Create an instance of {@link SearchByAdvancedResponse }
	 * 
	 */
	public SearchByAdvancedResponse createSearchByAdvancedResponse() {
		return new SearchByAdvancedResponse();
	}

	/**
	 * Create an instance of {@link InsufficientPrivilegesException }
	 * 
	 */
	public InsufficientPrivilegesException createInsufficientPrivilegesException() {
		return new InsufficientPrivilegesException();
	}

	/**
	 * Create an instance of {@link SearchSamplesBySampleNameResponse }
	 * 
	 */
	public SearchSamplesBySampleNameResponse createSearchSamplesBySampleNameResponse() {
		return new SearchSamplesBySampleNameResponse();
	}

	/**
	 * Create an instance of {@link ModifyDataSetParameterResponse }
	 * 
	 */
	public ModifyDataSetParameterResponse createModifyDataSetParameterResponse() {
		return new ModifyDataSetParameterResponse();
	}

	/**
	 * Create an instance of {@link CheckDatafileDownloadAccessResponse }
	 * 
	 */
	public CheckDatafileDownloadAccessResponse createCheckDatafileDownloadAccessResponse() {
		return new CheckDatafileDownloadAccessResponse();
	}

	/**
	 * Create an instance of {@link SearchByUserID }
	 * 
	 */
	public SearchByUserID createSearchByUserID() {
		return new SearchByUserID();
	}

	/**
	 * Create an instance of {@link AddInvestigatorResponse }
	 * 
	 */
	public AddInvestigatorResponse createAddInvestigatorResponse() {
		return new AddInvestigatorResponse();
	}

	/**
	 * Create an instance of {@link SearchByUserSurnameResponse }
	 * 
	 */
	public SearchByUserSurnameResponse createSearchByUserSurnameResponse() {
		return new SearchByUserSurnameResponse();
	}

	/**
	 * Create an instance of {@link Logout }
	 * 
	 */
	public Logout createLogout() {
		return new Logout();
	}

	/**
	 * Create an instance of {@link KeywordDetails }
	 * 
	 */
	public KeywordDetails createKeywordDetails() {
		return new KeywordDetails();
	}

	/**
	 * Create an instance of {@link Parameter }
	 * 
	 */
	public Parameter createParameter() {
		return new Parameter();
	}

	/**
	 * Create an instance of {@link GetKeywordsForUserType }
	 * 
	 */
	public GetKeywordsForUserType createGetKeywordsForUserType() {
		return new GetKeywordsForUserType();
	}

	/**
	 * Create an instance of {@link ModifySampleParameter }
	 * 
	 */
	public ModifySampleParameter createModifySampleParameter() {
		return new ModifySampleParameter();
	}

	/**
	 * Create an instance of {@link GetDatasets }
	 * 
	 */
	public GetDatasets createGetDatasets() {
		return new GetDatasets();
	}

	/**
	 * Create an instance of {@link DeleteDataFileParameterResponse }
	 * 
	 */
	public DeleteDataFileParameterResponse createDeleteDataFileParameterResponse() {
		return new DeleteDataFileParameterResponse();
	}

	/**
	 * Create an instance of {@link Publication }
	 * 
	 */
	public Publication createPublication() {
		return new Publication();
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ModifyInvestigatorResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "modifyInvestigatorResponse")
	public JAXBElement<ModifyInvestigatorResponse> createModifyInvestigatorResponse(
			ModifyInvestigatorResponse value) {
		return new JAXBElement<ModifyInvestigatorResponse>(
				_ModifyInvestigatorResponse_QNAME,
				ModifyInvestigatorResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link SearchByRunNumber }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "searchByRunNumber")
	public JAXBElement<SearchByRunNumber> createSearchByRunNumber(
			SearchByRunNumber value) {
		return new JAXBElement<SearchByRunNumber>(_SearchByRunNumber_QNAME,
				SearchByRunNumber.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link SearchByRunNumberPaginationResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "searchByRunNumberPaginationResponse")
	public JAXBElement<SearchByRunNumberPaginationResponse> createSearchByRunNumberPaginationResponse(
			SearchByRunNumberPaginationResponse value) {
		return new JAXBElement<SearchByRunNumberPaginationResponse>(
				_SearchByRunNumberPaginationResponse_QNAME,
				SearchByRunNumberPaginationResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetMyInvestigationsResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "getMyInvestigationsResponse")
	public JAXBElement<GetMyInvestigationsResponse> createGetMyInvestigationsResponse(
			GetMyInvestigationsResponse value) {
		return new JAXBElement<GetMyInvestigationsResponse>(
				_GetMyInvestigationsResponse_QNAME,
				GetMyInvestigationsResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link DeleteSample }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "deleteSample")
	public JAXBElement<DeleteSample> createDeleteSample(DeleteSample value) {
		return new JAXBElement<DeleteSample>(_DeleteSample_QNAME,
				DeleteSample.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link CreateDataFileResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "createDataFileResponse")
	public JAXBElement<CreateDataFileResponse> createCreateDataFileResponse(
			CreateDataFileResponse value) {
		return new JAXBElement<CreateDataFileResponse>(
				_CreateDataFileResponse_QNAME, CreateDataFileResponse.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link DeleteKeyword }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "deleteKeyword")
	public JAXBElement<DeleteKeyword> createDeleteKeyword(DeleteKeyword value) {
		return new JAXBElement<DeleteKeyword>(_DeleteKeyword_QNAME,
				DeleteKeyword.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link AddDataSetParameters }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "addDataSetParameters")
	public JAXBElement<AddDataSetParameters> createAddDataSetParameters(
			AddDataSetParameters value) {
		return new JAXBElement<AddDataSetParameters>(
				_AddDataSetParameters_QNAME, AddDataSetParameters.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Dataset }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "dataset")
	public JAXBElement<Dataset> createDataset(Dataset value) {
		return new JAXBElement<Dataset>(_Dataset_QNAME, Dataset.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link RemoveKeywordResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "removeKeywordResponse")
	public JAXBElement<RemoveKeywordResponse> createRemoveKeywordResponse(
			RemoveKeywordResponse value) {
		return new JAXBElement<RemoveKeywordResponse>(
				_RemoveKeywordResponse_QNAME, RemoveKeywordResponse.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetDatasetResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "getDatasetResponse")
	public JAXBElement<GetDatasetResponse> createGetDatasetResponse(
			GetDatasetResponse value) {
		return new JAXBElement<GetDatasetResponse>(_GetDatasetResponse_QNAME,
				GetDatasetResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ModifyInvestigation }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "modifyInvestigation")
	public JAXBElement<ModifyInvestigation> createModifyInvestigation(
			ModifyInvestigation value) {
		return new JAXBElement<ModifyInvestigation>(_ModifyInvestigation_QNAME,
				ModifyInvestigation.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetAuthorisations }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "getAuthorisations")
	public JAXBElement<GetAuthorisations> createGetAuthorisations(
			GetAuthorisations value) {
		return new JAXBElement<GetAuthorisations>(_GetAuthorisations_QNAME,
				GetAuthorisations.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link AddKeyword }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "addKeyword")
	public JAXBElement<AddKeyword> createAddKeyword(AddKeyword value) {
		return new JAXBElement<AddKeyword>(_AddKeyword_QNAME, AddKeyword.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link RemoveSampleResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "removeSampleResponse")
	public JAXBElement<RemoveSampleResponse> createRemoveSampleResponse(
			RemoveSampleResponse value) {
		return new JAXBElement<RemoveSampleResponse>(
				_RemoveSampleResponse_QNAME, RemoveSampleResponse.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link DatafileParameter }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "datafileParameter")
	public JAXBElement<DatafileParameter> createDatafileParameter(
			DatafileParameter value) {
		return new JAXBElement<DatafileParameter>(_DatafileParameter_QNAME,
				DatafileParameter.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ICATAPIException }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "ICATAPIException")
	public JAXBElement<ICATAPIException> createICATAPIException(
			ICATAPIException value) {
		return new JAXBElement<ICATAPIException>(_ICATAPIException_QNAME,
				ICATAPIException.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link AddPublicationResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "addPublicationResponse")
	public JAXBElement<AddPublicationResponse> createAddPublicationResponse(
			AddPublicationResponse value) {
		return new JAXBElement<AddPublicationResponse>(
				_AddPublicationResponse_QNAME, AddPublicationResponse.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ModifyDataSetParameter }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "modifyDataSetParameter")
	public JAXBElement<ModifyDataSetParameter> createModifyDataSetParameter(
			ModifyDataSetParameter value) {
		return new JAXBElement<ModifyDataSetParameter>(
				_ModifyDataSetParameter_QNAME, ModifyDataSetParameter.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link DownloadDatafile }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "downloadDatafile")
	public JAXBElement<DownloadDatafile> createDownloadDatafile(
			DownloadDatafile value) {
		return new JAXBElement<DownloadDatafile>(_DownloadDatafile_QNAME,
				DownloadDatafile.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link InsufficientPrivilegesException }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "InsufficientPrivilegesException")
	public JAXBElement<InsufficientPrivilegesException> createInsufficientPrivilegesException(
			InsufficientPrivilegesException value) {
		return new JAXBElement<InsufficientPrivilegesException>(
				_InsufficientPrivilegesException_QNAME,
				InsufficientPrivilegesException.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link UpdateAuthorisationResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "updateAuthorisationResponse")
	public JAXBElement<UpdateAuthorisationResponse> createUpdateAuthorisationResponse(
			UpdateAuthorisationResponse value) {
		return new JAXBElement<UpdateAuthorisationResponse>(
				_UpdateAuthorisationResponse_QNAME,
				UpdateAuthorisationResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetKeywordsForUser }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "getKeywordsForUser")
	public JAXBElement<GetKeywordsForUser> createGetKeywordsForUser(
			GetKeywordsForUser value) {
		return new JAXBElement<GetKeywordsForUser>(_GetKeywordsForUser_QNAME,
				GetKeywordsForUser.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ModifyInvestigationResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "modifyInvestigationResponse")
	public JAXBElement<ModifyInvestigationResponse> createModifyInvestigationResponse(
			ModifyInvestigationResponse value) {
		return new JAXBElement<ModifyInvestigationResponse>(
				_ModifyInvestigationResponse_QNAME,
				ModifyInvestigationResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link SetDataSetSample }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "setDataSetSample")
	public JAXBElement<SetDataSetSample> createSetDataSetSample(
			SetDataSetSample value) {
		return new JAXBElement<SetDataSetSample>(_SetDataSetSample_QNAME,
				SetDataSetSample.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link DeleteDataSetParameter }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "deleteDataSetParameter")
	public JAXBElement<DeleteDataSetParameter> createDeleteDataSetParameter(
			DeleteDataSetParameter value) {
		return new JAXBElement<DeleteDataSetParameter>(
				_DeleteDataSetParameter_QNAME, DeleteDataSetParameter.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetAuthorisationsResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "getAuthorisationsResponse")
	public JAXBElement<GetAuthorisationsResponse> createGetAuthorisationsResponse(
			GetAuthorisationsResponse value) {
		return new JAXBElement<GetAuthorisationsResponse>(
				_GetAuthorisationsResponse_QNAME,
				GetAuthorisationsResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link CreateDataSet }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "createDataSet")
	public JAXBElement<CreateDataSet> createCreateDataSet(CreateDataSet value) {
		return new JAXBElement<CreateDataSet>(_CreateDataSet_QNAME,
				CreateDataSet.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetDatasetIncludes }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "getDatasetIncludes")
	public JAXBElement<GetDatasetIncludes> createGetDatasetIncludes(
			GetDatasetIncludes value) {
		return new JAXBElement<GetDatasetIncludes>(_GetDatasetIncludes_QNAME,
				GetDatasetIncludes.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link DeleteInvestigator }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "deleteInvestigator")
	public JAXBElement<DeleteInvestigator> createDeleteInvestigator(
			DeleteInvestigator value) {
		return new JAXBElement<DeleteInvestigator>(_DeleteInvestigator_QNAME,
				DeleteInvestigator.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link DeleteKeywordResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "deleteKeywordResponse")
	public JAXBElement<DeleteKeywordResponse> createDeleteKeywordResponse(
			DeleteKeywordResponse value) {
		return new JAXBElement<DeleteKeywordResponse>(
				_DeleteKeywordResponse_QNAME, DeleteKeywordResponse.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetKeywordsForUserResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "getKeywordsForUserResponse")
	public JAXBElement<GetKeywordsForUserResponse> createGetKeywordsForUserResponse(
			GetKeywordsForUserResponse value) {
		return new JAXBElement<GetKeywordsForUserResponse>(
				_GetKeywordsForUserResponse_QNAME,
				GetKeywordsForUserResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link GetDatasets }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "getDatasets")
	public JAXBElement<GetDatasets> createGetDatasets(GetDatasets value) {
		return new JAXBElement<GetDatasets>(_GetDatasets_QNAME,
				GetDatasets.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link ListParameters }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "listParameters")
	public JAXBElement<ListParameters> createListParameters(ListParameters value) {
		return new JAXBElement<ListParameters>(_ListParameters_QNAME,
				ListParameters.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ModifyDataFileParameter }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "modifyDataFileParameter")
	public JAXBElement<ModifyDataFileParameter> createModifyDataFileParameter(
			ModifyDataFileParameter value) {
		return new JAXBElement<ModifyDataFileParameter>(
				_ModifyDataFileParameter_QNAME, ModifyDataFileParameter.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ModifyPublicationResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "modifyPublicationResponse")
	public JAXBElement<ModifyPublicationResponse> createModifyPublicationResponse(
			ModifyPublicationResponse value) {
		return new JAXBElement<ModifyPublicationResponse>(
				_ModifyPublicationResponse_QNAME,
				ModifyPublicationResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetKeywordsForUserStartWithMaxResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "getKeywordsForUserStartWithMaxResponse")
	public JAXBElement<GetKeywordsForUserStartWithMaxResponse> createGetKeywordsForUserStartWithMaxResponse(
			GetKeywordsForUserStartWithMaxResponse value) {
		return new JAXBElement<GetKeywordsForUserStartWithMaxResponse>(
				_GetKeywordsForUserStartWithMaxResponse_QNAME,
				GetKeywordsForUserStartWithMaxResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link AddDataFileParameter }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "addDataFileParameter")
	public JAXBElement<AddDataFileParameter> createAddDataFileParameter(
			AddDataFileParameter value) {
		return new JAXBElement<AddDataFileParameter>(
				_AddDataFileParameter_QNAME, AddDataFileParameter.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link DeleteDataSetParameterResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "deleteDataSetParameterResponse")
	public JAXBElement<DeleteDataSetParameterResponse> createDeleteDataSetParameterResponse(
			DeleteDataSetParameterResponse value) {
		return new JAXBElement<DeleteDataSetParameterResponse>(
				_DeleteDataSetParameterResponse_QNAME,
				DeleteDataSetParameterResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link CreateInvestigation }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "createInvestigation")
	public JAXBElement<CreateInvestigation> createCreateInvestigation(
			CreateInvestigation value) {
		return new JAXBElement<CreateInvestigation>(_CreateInvestigation_QNAME,
				CreateInvestigation.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link SearchDatasetsBySample }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "searchDatasetsBySample")
	public JAXBElement<SearchDatasetsBySample> createSearchDatasetsBySample(
			SearchDatasetsBySample value) {
		return new JAXBElement<SearchDatasetsBySample>(
				_SearchDatasetsBySample_QNAME, SearchDatasetsBySample.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link DeleteDataFileParameter }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "deleteDataFileParameter")
	public JAXBElement<DeleteDataFileParameter> createDeleteDataFileParameter(
			DeleteDataFileParameter value) {
		return new JAXBElement<DeleteDataFileParameter>(
				_DeleteDataFileParameter_QNAME, DeleteDataFileParameter.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ListDatasetTypesResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "listDatasetTypesResponse")
	public JAXBElement<ListDatasetTypesResponse> createListDatasetTypesResponse(
			ListDatasetTypesResponse value) {
		return new JAXBElement<ListDatasetTypesResponse>(
				_ListDatasetTypesResponse_QNAME,
				ListDatasetTypesResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link CheckDatasetDownloadAccessResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "checkDatasetDownloadAccessResponse")
	public JAXBElement<CheckDatasetDownloadAccessResponse> createCheckDatasetDownloadAccessResponse(
			CheckDatasetDownloadAccessResponse value) {
		return new JAXBElement<CheckDatasetDownloadAccessResponse>(
				_CheckDatasetDownloadAccessResponse_QNAME,
				CheckDatasetDownloadAccessResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Datafile }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "datafile")
	public JAXBElement<Datafile> createDatafile(Datafile value) {
		return new JAXBElement<Datafile>(_Datafile_QNAME, Datafile.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link AddDataFileParametersResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "addDataFileParametersResponse")
	public JAXBElement<AddDataFileParametersResponse> createAddDataFileParametersResponse(
			AddDataFileParametersResponse value) {
		return new JAXBElement<AddDataFileParametersResponse>(
				_AddDataFileParametersResponse_QNAME,
				AddDataFileParametersResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link IngestMetadata }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "ingestMetadata")
	public JAXBElement<IngestMetadata> createIngestMetadata(IngestMetadata value) {
		return new JAXBElement<IngestMetadata>(_IngestMetadata_QNAME,
				IngestMetadata.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetDatafileResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "getDatafileResponse")
	public JAXBElement<GetDatafileResponse> createGetDatafileResponse(
			GetDatafileResponse value) {
		return new JAXBElement<GetDatafileResponse>(_GetDatafileResponse_QNAME,
				GetDatafileResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link ListRoles }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "listRoles")
	public JAXBElement<ListRoles> createListRoles(ListRoles value) {
		return new JAXBElement<ListRoles>(_ListRoles_QNAME, ListRoles.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link DeleteAuthorisation }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "deleteAuthorisation")
	public JAXBElement<DeleteAuthorisation> createDeleteAuthorisation(
			DeleteAuthorisation value) {
		return new JAXBElement<DeleteAuthorisation>(_DeleteAuthorisation_QNAME,
				DeleteAuthorisation.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link LogoutResponse }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "logoutResponse")
	public JAXBElement<LogoutResponse> createLogoutResponse(LogoutResponse value) {
		return new JAXBElement<LogoutResponse>(_LogoutResponse_QNAME,
				LogoutResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetMyInvestigationsIncludesPagination }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "getMyInvestigationsIncludesPagination")
	public JAXBElement<GetMyInvestigationsIncludesPagination> createGetMyInvestigationsIncludesPagination(
			GetMyInvestigationsIncludesPagination value) {
		return new JAXBElement<GetMyInvestigationsIncludesPagination>(
				_GetMyInvestigationsIncludesPagination_QNAME,
				GetMyInvestigationsIncludesPagination.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link UpdateAuthorisation }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "updateAuthorisation")
	public JAXBElement<UpdateAuthorisation> createUpdateAuthorisation(
			UpdateAuthorisation value) {
		return new JAXBElement<UpdateAuthorisation>(_UpdateAuthorisation_QNAME,
				UpdateAuthorisation.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link GetDataset }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "getDataset")
	public JAXBElement<GetDataset> createGetDataset(GetDataset value) {
		return new JAXBElement<GetDataset>(_GetDataset_QNAME, GetDataset.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetKeywordsForUserMaxResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "getKeywordsForUserMaxResponse")
	public JAXBElement<GetKeywordsForUserMaxResponse> createGetKeywordsForUserMaxResponse(
			GetKeywordsForUserMaxResponse value) {
		return new JAXBElement<GetKeywordsForUserMaxResponse>(
				_GetKeywordsForUserMaxResponse_QNAME,
				GetKeywordsForUserMaxResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link AddAuthorisationResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "addAuthorisationResponse")
	public JAXBElement<AddAuthorisationResponse> createAddAuthorisationResponse(
			AddAuthorisationResponse value) {
		return new JAXBElement<AddAuthorisationResponse>(
				_AddAuthorisationResponse_QNAME,
				AddAuthorisationResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Investigation }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "investigation")
	public JAXBElement<Investigation> createInvestigation(Investigation value) {
		return new JAXBElement<Investigation>(_Investigation_QNAME,
				Investigation.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link CheckDatafileDownloadAccessResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "checkDatafileDownloadAccessResponse")
	public JAXBElement<CheckDatafileDownloadAccessResponse> createCheckDatafileDownloadAccessResponse(
			CheckDatafileDownloadAccessResponse value) {
		return new JAXBElement<CheckDatafileDownloadAccessResponse>(
				_CheckDatafileDownloadAccessResponse_QNAME,
				CheckDatafileDownloadAccessResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link AddSample }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "addSample")
	public JAXBElement<AddSample> createAddSample(AddSample value) {
		return new JAXBElement<AddSample>(_AddSample_QNAME, AddSample.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link DownloadDatasetResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "downloadDatasetResponse")
	public JAXBElement<DownloadDatasetResponse> createDownloadDatasetResponse(
			DownloadDatasetResponse value) {
		return new JAXBElement<DownloadDatasetResponse>(
				_DownloadDatasetResponse_QNAME, DownloadDatasetResponse.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link DeleteInvestigatorResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "deleteInvestigatorResponse")
	public JAXBElement<DeleteInvestigatorResponse> createDeleteInvestigatorResponse(
			DeleteInvestigatorResponse value) {
		return new JAXBElement<DeleteInvestigatorResponse>(
				_DeleteInvestigatorResponse_QNAME,
				DeleteInvestigatorResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link AddAuthorisation }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "addAuthorisation")
	public JAXBElement<AddAuthorisation> createAddAuthorisation(
			AddAuthorisation value) {
		return new JAXBElement<AddAuthorisation>(_AddAuthorisation_QNAME,
				AddAuthorisation.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link AddDataSetParameter }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "addDataSetParameter")
	public JAXBElement<AddDataSetParameter> createAddDataSetParameter(
			AddDataSetParameter value) {
		return new JAXBElement<AddDataSetParameter>(_AddDataSetParameter_QNAME,
				AddDataSetParameter.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link CreateDataFiles }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "createDataFiles")
	public JAXBElement<CreateDataFiles> createCreateDataFiles(
			CreateDataFiles value) {
		return new JAXBElement<CreateDataFiles>(_CreateDataFiles_QNAME,
				CreateDataFiles.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link CreateDataFilesResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "createDataFilesResponse")
	public JAXBElement<CreateDataFilesResponse> createCreateDataFilesResponse(
			CreateDataFilesResponse value) {
		return new JAXBElement<CreateDataFilesResponse>(
				_CreateDataFilesResponse_QNAME, CreateDataFilesResponse.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ModifySampleParameter }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "modifySampleParameter")
	public JAXBElement<ModifySampleParameter> createModifySampleParameter(
			ModifySampleParameter value) {
		return new JAXBElement<ModifySampleParameter>(
				_ModifySampleParameter_QNAME, ModifySampleParameter.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link RemoveDataFileResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "removeDataFileResponse")
	public JAXBElement<RemoveDataFileResponse> createRemoveDataFileResponse(
			RemoveDataFileResponse value) {
		return new JAXBElement<RemoveDataFileResponse>(
				_RemoveDataFileResponse_QNAME, RemoveDataFileResponse.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Investigator }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "investigator")
	public JAXBElement<Investigator> createInvestigator(Investigator value) {
		return new JAXBElement<Investigator>(_Investigator_QNAME,
				Investigator.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link DeleteInvestigation }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "deleteInvestigation")
	public JAXBElement<DeleteInvestigation> createDeleteInvestigation(
			DeleteInvestigation value) {
		return new JAXBElement<DeleteInvestigation>(_DeleteInvestigation_QNAME,
				DeleteInvestigation.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ListInstrumentsResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "listInstrumentsResponse")
	public JAXBElement<ListInstrumentsResponse> createListInstrumentsResponse(
			ListInstrumentsResponse value) {
		return new JAXBElement<ListInstrumentsResponse>(
				_ListInstrumentsResponse_QNAME, ListInstrumentsResponse.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link RemoveKeyword }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "removeKeyword")
	public JAXBElement<RemoveKeyword> createRemoveKeyword(RemoveKeyword value) {
		return new JAXBElement<RemoveKeyword>(_RemoveKeyword_QNAME,
				RemoveKeyword.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link RemoveInvestigation }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "removeInvestigation")
	public JAXBElement<RemoveInvestigation> createRemoveInvestigation(
			RemoveInvestigation value) {
		return new JAXBElement<RemoveInvestigation>(_RemoveInvestigation_QNAME,
				RemoveInvestigation.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetDatasetsResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "getDatasetsResponse")
	public JAXBElement<GetDatasetsResponse> createGetDatasetsResponse(
			GetDatasetsResponse value) {
		return new JAXBElement<GetDatasetsResponse>(_GetDatasetsResponse_QNAME,
				GetDatasetsResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link DeleteDataFileParameterResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "deleteDataFileParameterResponse")
	public JAXBElement<DeleteDataFileParameterResponse> createDeleteDataFileParameterResponse(
			DeleteDataFileParameterResponse value) {
		return new JAXBElement<DeleteDataFileParameterResponse>(
				_DeleteDataFileParameterResponse_QNAME,
				DeleteDataFileParameterResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Logout }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "logout")
	public JAXBElement<Logout> createLogout(Logout value) {
		return new JAXBElement<Logout>(_Logout_QNAME, Logout.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link SearchByAdvancedPagination }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "searchByAdvancedPagination")
	public JAXBElement<SearchByAdvancedPagination> createSearchByAdvancedPagination(
			SearchByAdvancedPagination value) {
		return new JAXBElement<SearchByAdvancedPagination>(
				_SearchByAdvancedPagination_QNAME,
				SearchByAdvancedPagination.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link DeleteSampleParameterResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "deleteSampleParameterResponse")
	public JAXBElement<DeleteSampleParameterResponse> createDeleteSampleParameterResponse(
			DeleteSampleParameterResponse value) {
		return new JAXBElement<DeleteSampleParameterResponse>(
				_DeleteSampleParameterResponse_QNAME,
				DeleteSampleParameterResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link AddDataSetParametersResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "addDataSetParametersResponse")
	public JAXBElement<AddDataSetParametersResponse> createAddDataSetParametersResponse(
			AddDataSetParametersResponse value) {
		return new JAXBElement<AddDataSetParametersResponse>(
				_AddDataSetParametersResponse_QNAME,
				AddDataSetParametersResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link RemoveDataFile }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "removeDataFile")
	public JAXBElement<RemoveDataFile> createRemoveDataFile(RemoveDataFile value) {
		return new JAXBElement<RemoveDataFile>(_RemoveDataFile_QNAME,
				RemoveDataFile.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link SearchByKeywordsAll }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "searchByKeywordsAll")
	public JAXBElement<SearchByKeywordsAll> createSearchByKeywordsAll(
			SearchByKeywordsAll value) {
		return new JAXBElement<SearchByKeywordsAll>(_SearchByKeywordsAll_QNAME,
				SearchByKeywordsAll.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetDatafilesResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "getDatafilesResponse")
	public JAXBElement<GetDatafilesResponse> createGetDatafilesResponse(
			GetDatafilesResponse value) {
		return new JAXBElement<GetDatafilesResponse>(
				_GetDatafilesResponse_QNAME, GetDatafilesResponse.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ModifyDataFileParameterResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "modifyDataFileParameterResponse")
	public JAXBElement<ModifyDataFileParameterResponse> createModifyDataFileParameterResponse(
			ModifyDataFileParameterResponse value) {
		return new JAXBElement<ModifyDataFileParameterResponse>(
				_ModifyDataFileParameterResponse_QNAME,
				ModifyDataFileParameterResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link ModifySample }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "modifySample")
	public JAXBElement<ModifySample> createModifySample(ModifySample value) {
		return new JAXBElement<ModifySample>(_ModifySample_QNAME,
				ModifySample.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link CreateDataFile }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "createDataFile")
	public JAXBElement<CreateDataFile> createCreateDataFile(CreateDataFile value) {
		return new JAXBElement<CreateDataFile>(_CreateDataFile_QNAME,
				CreateDataFile.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link SetDataSetSampleResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "setDataSetSampleResponse")
	public JAXBElement<SetDataSetSampleResponse> createSetDataSetSampleResponse(
			SetDataSetSampleResponse value) {
		return new JAXBElement<SetDataSetSampleResponse>(
				_SetDataSetSampleResponse_QNAME,
				SetDataSetSampleResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link SearchSamplesBySampleName }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "searchSamplesBySampleName")
	public JAXBElement<SearchSamplesBySampleName> createSearchSamplesBySampleName(
			SearchSamplesBySampleName value) {
		return new JAXBElement<SearchSamplesBySampleName>(
				_SearchSamplesBySampleName_QNAME,
				SearchSamplesBySampleName.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link SearchByAdvancedPaginationResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "searchByAdvancedPaginationResponse")
	public JAXBElement<SearchByAdvancedPaginationResponse> createSearchByAdvancedPaginationResponse(
			SearchByAdvancedPaginationResponse value) {
		return new JAXBElement<SearchByAdvancedPaginationResponse>(
				_SearchByAdvancedPaginationResponse_QNAME,
				SearchByAdvancedPaginationResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link RemoveInvestigatorResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "removeInvestigatorResponse")
	public JAXBElement<RemoveInvestigatorResponse> createRemoveInvestigatorResponse(
			RemoveInvestigatorResponse value) {
		return new JAXBElement<RemoveInvestigatorResponse>(
				_RemoveInvestigatorResponse_QNAME,
				RemoveInvestigatorResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetInvestigationIncludes }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "getInvestigationIncludes")
	public JAXBElement<GetInvestigationIncludes> createGetInvestigationIncludes(
			GetInvestigationIncludes value) {
		return new JAXBElement<GetInvestigationIncludes>(
				_GetInvestigationIncludes_QNAME,
				GetInvestigationIncludes.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link RemoveDataFileParameter }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "removeDataFileParameter")
	public JAXBElement<RemoveDataFileParameter> createRemoveDataFileParameter(
			RemoveDataFileParameter value) {
		return new JAXBElement<RemoveDataFileParameter>(
				_RemoveDataFileParameter_QNAME, RemoveDataFileParameter.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ModifyPublication }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "modifyPublication")
	public JAXBElement<ModifyPublication> createModifyPublication(
			ModifyPublication value) {
		return new JAXBElement<ModifyPublication>(_ModifyPublication_QNAME,
				ModifyPublication.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ModifyDataSetParameterResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "modifyDataSetParameterResponse")
	public JAXBElement<ModifyDataSetParameterResponse> createModifyDataSetParameterResponse(
			ModifyDataSetParameterResponse value) {
		return new JAXBElement<ModifyDataSetParameterResponse>(
				_ModifyDataSetParameterResponse_QNAME,
				ModifyDataSetParameterResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link AddDataFileParameterResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "addDataFileParameterResponse")
	public JAXBElement<AddDataFileParameterResponse> createAddDataFileParameterResponse(
			AddDataFileParameterResponse value) {
		return new JAXBElement<AddDataFileParameterResponse>(
				_AddDataFileParameterResponse_QNAME,
				AddDataFileParameterResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link RemoveDataSetParameter }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "removeDataSetParameter")
	public JAXBElement<RemoveDataSetParameter> createRemoveDataSetParameter(
			RemoveDataSetParameter value) {
		return new JAXBElement<RemoveDataSetParameter>(
				_RemoveDataSetParameter_QNAME, RemoveDataSetParameter.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link RemoveSampleParameterResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "removeSampleParameterResponse")
	public JAXBElement<RemoveSampleParameterResponse> createRemoveSampleParameterResponse(
			RemoveSampleParameterResponse value) {
		return new JAXBElement<RemoveSampleParameterResponse>(
				_RemoveSampleParameterResponse_QNAME,
				RemoveSampleParameterResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetMyInvestigations }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "getMyInvestigations")
	public JAXBElement<GetMyInvestigations> createGetMyInvestigations(
			GetMyInvestigations value) {
		return new JAXBElement<GetMyInvestigations>(_GetMyInvestigations_QNAME,
				GetMyInvestigations.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link SearchByUserIDPaginationResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "searchByUserIDPaginationResponse")
	public JAXBElement<SearchByUserIDPaginationResponse> createSearchByUserIDPaginationResponse(
			SearchByUserIDPaginationResponse value) {
		return new JAXBElement<SearchByUserIDPaginationResponse>(
				_SearchByUserIDPaginationResponse_QNAME,
				SearchByUserIDPaginationResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link NoSuchObjectFoundException }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "NoSuchObjectFoundException")
	public JAXBElement<NoSuchObjectFoundException> createNoSuchObjectFoundException(
			NoSuchObjectFoundException value) {
		return new JAXBElement<NoSuchObjectFoundException>(
				_NoSuchObjectFoundException_QNAME,
				NoSuchObjectFoundException.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetMyInvestigationsIncludesPaginationResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "getMyInvestigationsIncludesPaginationResponse")
	public JAXBElement<GetMyInvestigationsIncludesPaginationResponse> createGetMyInvestigationsIncludesPaginationResponse(
			GetMyInvestigationsIncludesPaginationResponse value) {
		return new JAXBElement<GetMyInvestigationsIncludesPaginationResponse>(
				_GetMyInvestigationsIncludesPaginationResponse_QNAME,
				GetMyInvestigationsIncludesPaginationResponse.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link SearchByKeywords }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "searchByKeywords")
	public JAXBElement<SearchByKeywords> createSearchByKeywords(
			SearchByKeywords value) {
		return new JAXBElement<SearchByKeywords>(_SearchByKeywords_QNAME,
				SearchByKeywords.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link CheckDatasetDownloadAccess }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "checkDatasetDownloadAccess")
	public JAXBElement<CheckDatasetDownloadAccess> createCheckDatasetDownloadAccess(
			CheckDatasetDownloadAccess value) {
		return new JAXBElement<CheckDatasetDownloadAccess>(
				_CheckDatasetDownloadAccess_QNAME,
				CheckDatasetDownloadAccess.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link SearchByUserSurname }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "searchByUserSurname")
	public JAXBElement<SearchByUserSurname> createSearchByUserSurname(
			SearchByUserSurname value) {
		return new JAXBElement<SearchByUserSurname>(_SearchByUserSurname_QNAME,
				SearchByUserSurname.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ListDatasetStatusResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "listDatasetStatusResponse")
	public JAXBElement<ListDatasetStatusResponse> createListDatasetStatusResponse(
			ListDatasetStatusResponse value) {
		return new JAXBElement<ListDatasetStatusResponse>(
				_ListDatasetStatusResponse_QNAME,
				ListDatasetStatusResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetKeywordsForUserType }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "getKeywordsForUserType")
	public JAXBElement<GetKeywordsForUserType> createGetKeywordsForUserType(
			GetKeywordsForUserType value) {
		return new JAXBElement<GetKeywordsForUserType>(
				_GetKeywordsForUserType_QNAME, GetKeywordsForUserType.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetInvestigationsIncludes }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "getInvestigationsIncludes")
	public JAXBElement<GetInvestigationsIncludes> createGetInvestigationsIncludes(
			GetInvestigationsIncludes value) {
		return new JAXBElement<GetInvestigationsIncludes>(
				_GetInvestigationsIncludes_QNAME,
				GetInvestigationsIncludes.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link CheckDatafileDownloadAccess }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "checkDatafileDownloadAccess")
	public JAXBElement<CheckDatafileDownloadAccess> createCheckDatafileDownloadAccess(
			CheckDatafileDownloadAccess value) {
		return new JAXBElement<CheckDatafileDownloadAccess>(
				_CheckDatafileDownloadAccess_QNAME,
				CheckDatafileDownloadAccess.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link DownloadDatafiles }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "downloadDatafiles")
	public JAXBElement<DownloadDatafiles> createDownloadDatafiles(
			DownloadDatafiles value) {
		return new JAXBElement<DownloadDatafiles>(_DownloadDatafiles_QNAME,
				DownloadDatafiles.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link DeleteInvestigationResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "deleteInvestigationResponse")
	public JAXBElement<DeleteInvestigationResponse> createDeleteInvestigationResponse(
			DeleteInvestigationResponse value) {
		return new JAXBElement<DeleteInvestigationResponse>(
				_DeleteInvestigationResponse_QNAME,
				DeleteInvestigationResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link RemovePublication }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "removePublication")
	public JAXBElement<RemovePublication> createRemovePublication(
			RemovePublication value) {
		return new JAXBElement<RemovePublication>(_RemovePublication_QNAME,
				RemovePublication.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link FacilityUser }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "facilityUser")
	public JAXBElement<FacilityUser> createFacilityUser(FacilityUser value) {
		return new JAXBElement<FacilityUser>(_FacilityUser_QNAME,
				FacilityUser.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ListDatasetStatus }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "listDatasetStatus")
	public JAXBElement<ListDatasetStatus> createListDatasetStatus(
			ListDatasetStatus value) {
		return new JAXBElement<ListDatasetStatus>(_ListDatasetStatus_QNAME,
				ListDatasetStatus.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetKeywordsForUserTypeResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "getKeywordsForUserTypeResponse")
	public JAXBElement<GetKeywordsForUserTypeResponse> createGetKeywordsForUserTypeResponse(
			GetKeywordsForUserTypeResponse value) {
		return new JAXBElement<GetKeywordsForUserTypeResponse>(
				_GetKeywordsForUserTypeResponse_QNAME,
				GetKeywordsForUserTypeResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link SearchByRunNumberPagination }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "searchByRunNumberPagination")
	public JAXBElement<SearchByRunNumberPagination> createSearchByRunNumberPagination(
			SearchByRunNumberPagination value) {
		return new JAXBElement<SearchByRunNumberPagination>(
				_SearchByRunNumberPagination_QNAME,
				SearchByRunNumberPagination.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link RemoveDataSet }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "removeDataSet")
	public JAXBElement<RemoveDataSet> createRemoveDataSet(RemoveDataSet value) {
		return new JAXBElement<RemoveDataSet>(_RemoveDataSet_QNAME,
				RemoveDataSet.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link DeleteSampleResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "deleteSampleResponse")
	public JAXBElement<DeleteSampleResponse> createDeleteSampleResponse(
			DeleteSampleResponse value) {
		return new JAXBElement<DeleteSampleResponse>(
				_DeleteSampleResponse_QNAME, DeleteSampleResponse.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ModifySampleResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "modifySampleResponse")
	public JAXBElement<ModifySampleResponse> createModifySampleResponse(
			ModifySampleResponse value) {
		return new JAXBElement<ModifySampleResponse>(
				_ModifySampleResponse_QNAME, ModifySampleResponse.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link RemovePublicationResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "removePublicationResponse")
	public JAXBElement<RemovePublicationResponse> createRemovePublicationResponse(
			RemovePublicationResponse value) {
		return new JAXBElement<RemovePublicationResponse>(
				_RemovePublicationResponse_QNAME,
				RemovePublicationResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ListInvestigationTypes }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "listInvestigationTypes")
	public JAXBElement<ListInvestigationTypes> createListInvestigationTypes(
			ListInvestigationTypes value) {
		return new JAXBElement<ListInvestigationTypes>(
				_ListInvestigationTypes_QNAME, ListInvestigationTypes.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ListParametersResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "listParametersResponse")
	public JAXBElement<ListParametersResponse> createListParametersResponse(
			ListParametersResponse value) {
		return new JAXBElement<ListParametersResponse>(
				_ListParametersResponse_QNAME, ListParametersResponse.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link SearchByUserIDResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "searchByUserIDResponse")
	public JAXBElement<SearchByUserIDResponse> createSearchByUserIDResponse(
			SearchByUserIDResponse value) {
		return new JAXBElement<SearchByUserIDResponse>(
				_SearchByUserIDResponse_QNAME, SearchByUserIDResponse.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link RemoveSampleParameter }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "removeSampleParameter")
	public JAXBElement<RemoveSampleParameter> createRemoveSampleParameter(
			RemoveSampleParameter value) {
		return new JAXBElement<RemoveSampleParameter>(
				_RemoveSampleParameter_QNAME, RemoveSampleParameter.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link AddInvestigator }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "addInvestigator")
	public JAXBElement<AddInvestigator> createAddInvestigator(
			AddInvestigator value) {
		return new JAXBElement<AddInvestigator>(_AddInvestigator_QNAME,
				AddInvestigator.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link RemoveDataSetResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "removeDataSetResponse")
	public JAXBElement<RemoveDataSetResponse> createRemoveDataSetResponse(
			RemoveDataSetResponse value) {
		return new JAXBElement<RemoveDataSetResponse>(
				_RemoveDataSetResponse_QNAME, RemoveDataSetResponse.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link SearchByKeywordsAllResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "searchByKeywordsAllResponse")
	public JAXBElement<SearchByKeywordsAllResponse> createSearchByKeywordsAllResponse(
			SearchByKeywordsAllResponse value) {
		return new JAXBElement<SearchByKeywordsAllResponse>(
				_SearchByKeywordsAllResponse_QNAME,
				SearchByKeywordsAllResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link RemoveInvestigationResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "removeInvestigationResponse")
	public JAXBElement<RemoveInvestigationResponse> createRemoveInvestigationResponse(
			RemoveInvestigationResponse value) {
		return new JAXBElement<RemoveInvestigationResponse>(
				_RemoveInvestigationResponse_QNAME,
				RemoveInvestigationResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ListInvestigationTypesResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "listInvestigationTypesResponse")
	public JAXBElement<ListInvestigationTypesResponse> createListInvestigationTypesResponse(
			ListInvestigationTypesResponse value) {
		return new JAXBElement<ListInvestigationTypesResponse>(
				_ListInvestigationTypesResponse_QNAME,
				ListInvestigationTypesResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link GetDatafiles }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "getDatafiles")
	public JAXBElement<GetDatafiles> createGetDatafiles(GetDatafiles value) {
		return new JAXBElement<GetDatafiles>(_GetDatafiles_QNAME,
				GetDatafiles.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetMyInvestigationsIncludes }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "getMyInvestigationsIncludes")
	public JAXBElement<GetMyInvestigationsIncludes> createGetMyInvestigationsIncludes(
			GetMyInvestigationsIncludes value) {
		return new JAXBElement<GetMyInvestigationsIncludes>(
				_GetMyInvestigationsIncludes_QNAME,
				GetMyInvestigationsIncludes.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link DeleteDataSet }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "deleteDataSet")
	public JAXBElement<DeleteDataSet> createDeleteDataSet(DeleteDataSet value) {
		return new JAXBElement<DeleteDataSet>(_DeleteDataSet_QNAME,
				DeleteDataSet.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link DeleteSampleParameter }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "deleteSampleParameter")
	public JAXBElement<DeleteSampleParameter> createDeleteSampleParameter(
			DeleteSampleParameter value) {
		return new JAXBElement<DeleteSampleParameter>(
				_DeleteSampleParameter_QNAME, DeleteSampleParameter.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetKeywordsForUserMax }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "getKeywordsForUserMax")
	public JAXBElement<GetKeywordsForUserMax> createGetKeywordsForUserMax(
			GetKeywordsForUserMax value) {
		return new JAXBElement<GetKeywordsForUserMax>(
				_GetKeywordsForUserMax_QNAME, GetKeywordsForUserMax.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link AddPublication }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "addPublication")
	public JAXBElement<AddPublication> createAddPublication(AddPublication value) {
		return new JAXBElement<AddPublication>(_AddPublication_QNAME,
				AddPublication.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link SearchByUserIDPagination }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "searchByUserIDPagination")
	public JAXBElement<SearchByUserIDPagination> createSearchByUserIDPagination(
			SearchByUserIDPagination value) {
		return new JAXBElement<SearchByUserIDPagination>(
				_SearchByUserIDPagination_QNAME,
				SearchByUserIDPagination.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link SessionException }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "SessionException")
	public JAXBElement<SessionException> createSessionException(
			SessionException value) {
		return new JAXBElement<SessionException>(_SessionException_QNAME,
				SessionException.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetInvestigation }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "getInvestigation")
	public JAXBElement<GetInvestigation> createGetInvestigation(
			GetInvestigation value) {
		return new JAXBElement<GetInvestigation>(_GetInvestigation_QNAME,
				GetInvestigation.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link DeleteAuthorisationResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "deleteAuthorisationResponse")
	public JAXBElement<DeleteAuthorisationResponse> createDeleteAuthorisationResponse(
			DeleteAuthorisationResponse value) {
		return new JAXBElement<DeleteAuthorisationResponse>(
				_DeleteAuthorisationResponse_QNAME,
				DeleteAuthorisationResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link GetDatafile }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "getDatafile")
	public JAXBElement<GetDatafile> createGetDatafile(GetDatafile value) {
		return new JAXBElement<GetDatafile>(_GetDatafile_QNAME,
				GetDatafile.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link ModifyDataFile }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "modifyDataFile")
	public JAXBElement<ModifyDataFile> createModifyDataFile(ModifyDataFile value) {
		return new JAXBElement<ModifyDataFile>(_ModifyDataFile_QNAME,
				ModifyDataFile.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link DeleteDataSetResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "deleteDataSetResponse")
	public JAXBElement<DeleteDataSetResponse> createDeleteDataSetResponse(
			DeleteDataSetResponse value) {
		return new JAXBElement<DeleteDataSetResponse>(
				_DeleteDataSetResponse_QNAME, DeleteDataSetResponse.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link LoginLifetime }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "loginLifetime")
	public JAXBElement<LoginLifetime> createLoginLifetime(LoginLifetime value) {
		return new JAXBElement<LoginLifetime>(_LoginLifetime_QNAME,
				LoginLifetime.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link DeletePublicationResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "deletePublicationResponse")
	public JAXBElement<DeletePublicationResponse> createDeletePublicationResponse(
			DeletePublicationResponse value) {
		return new JAXBElement<DeletePublicationResponse>(
				_DeletePublicationResponse_QNAME,
				DeletePublicationResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "login")
	public JAXBElement<Login> createLogin(Login value) {
		return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link DeletePublication }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "deletePublication")
	public JAXBElement<DeletePublication> createDeletePublication(
			DeletePublication value) {
		return new JAXBElement<DeletePublication>(_DeletePublication_QNAME,
				DeletePublication.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ListDatafileFormatsResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "listDatafileFormatsResponse")
	public JAXBElement<ListDatafileFormatsResponse> createListDatafileFormatsResponse(
			ListDatafileFormatsResponse value) {
		return new JAXBElement<ListDatafileFormatsResponse>(
				_ListDatafileFormatsResponse_QNAME,
				ListDatafileFormatsResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link CreateInvestigationResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "createInvestigationResponse")
	public JAXBElement<CreateInvestigationResponse> createCreateInvestigationResponse(
			CreateInvestigationResponse value) {
		return new JAXBElement<CreateInvestigationResponse>(
				_CreateInvestigationResponse_QNAME,
				CreateInvestigationResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ModifyInvestigator }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "modifyInvestigator")
	public JAXBElement<ModifyInvestigator> createModifyInvestigator(
			ModifyInvestigator value) {
		return new JAXBElement<ModifyInvestigator>(_ModifyInvestigator_QNAME,
				ModifyInvestigator.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link IngestMetadataResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "ingestMetadataResponse")
	public JAXBElement<IngestMetadataResponse> createIngestMetadataResponse(
			IngestMetadataResponse value) {
		return new JAXBElement<IngestMetadataResponse>(
				_IngestMetadataResponse_QNAME, IngestMetadataResponse.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ListDatafileFormats }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "listDatafileFormats")
	public JAXBElement<ListDatafileFormats> createListDatafileFormats(
			ListDatafileFormats value) {
		return new JAXBElement<ListDatafileFormats>(_ListDatafileFormats_QNAME,
				ListDatafileFormats.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link LoginLifetimeResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "loginLifetimeResponse")
	public JAXBElement<LoginLifetimeResponse> createLoginLifetimeResponse(
			LoginLifetimeResponse value) {
		return new JAXBElement<LoginLifetimeResponse>(
				_LoginLifetimeResponse_QNAME, LoginLifetimeResponse.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetKeywordsForUserStartWithMax }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "getKeywordsForUserStartWithMax")
	public JAXBElement<GetKeywordsForUserStartWithMax> createGetKeywordsForUserStartWithMax(
			GetKeywordsForUserStartWithMax value) {
		return new JAXBElement<GetKeywordsForUserStartWithMax>(
				_GetKeywordsForUserStartWithMax_QNAME,
				GetKeywordsForUserStartWithMax.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link AddKeywordResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "addKeywordResponse")
	public JAXBElement<AddKeywordResponse> createAddKeywordResponse(
			AddKeywordResponse value) {
		return new JAXBElement<AddKeywordResponse>(_AddKeywordResponse_QNAME,
				AddKeywordResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link SearchByAdvanced }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "searchByAdvanced")
	public JAXBElement<SearchByAdvanced> createSearchByAdvanced(
			SearchByAdvanced value) {
		return new JAXBElement<SearchByAdvanced>(_SearchByAdvanced_QNAME,
				SearchByAdvanced.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ModifySampleParameterResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "modifySampleParameterResponse")
	public JAXBElement<ModifySampleParameterResponse> createModifySampleParameterResponse(
			ModifySampleParameterResponse value) {
		return new JAXBElement<ModifySampleParameterResponse>(
				_ModifySampleParameterResponse_QNAME,
				ModifySampleParameterResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetInvestigationIncludesResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "getInvestigationIncludesResponse")
	public JAXBElement<GetInvestigationIncludesResponse> createGetInvestigationIncludesResponse(
			GetInvestigationIncludesResponse value) {
		return new JAXBElement<GetInvestigationIncludesResponse>(
				_GetInvestigationIncludesResponse_QNAME,
				GetInvestigationIncludesResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ModifyDataFileResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "modifyDataFileResponse")
	public JAXBElement<ModifyDataFileResponse> createModifyDataFileResponse(
			ModifyDataFileResponse value) {
		return new JAXBElement<ModifyDataFileResponse>(
				_ModifyDataFileResponse_QNAME, ModifyDataFileResponse.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetAllKeywordsResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "getAllKeywordsResponse")
	public JAXBElement<GetAllKeywordsResponse> createGetAllKeywordsResponse(
			GetAllKeywordsResponse value) {
		return new JAXBElement<GetAllKeywordsResponse>(
				_GetAllKeywordsResponse_QNAME, GetAllKeywordsResponse.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link SearchByRunNumberResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "searchByRunNumberResponse")
	public JAXBElement<SearchByRunNumberResponse> createSearchByRunNumberResponse(
			SearchByRunNumberResponse value) {
		return new JAXBElement<SearchByRunNumberResponse>(
				_SearchByRunNumberResponse_QNAME,
				SearchByRunNumberResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link CreateDataSets }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "createDataSets")
	public JAXBElement<CreateDataSets> createCreateDataSets(CreateDataSets value) {
		return new JAXBElement<CreateDataSets>(_CreateDataSets_QNAME,
				CreateDataSets.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link SearchByKeywordsResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "searchByKeywordsResponse")
	public JAXBElement<SearchByKeywordsResponse> createSearchByKeywordsResponse(
			SearchByKeywordsResponse value) {
		return new JAXBElement<SearchByKeywordsResponse>(
				_SearchByKeywordsResponse_QNAME,
				SearchByKeywordsResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link RemoveInvestigator }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "removeInvestigator")
	public JAXBElement<RemoveInvestigator> createRemoveInvestigator(
			RemoveInvestigator value) {
		return new JAXBElement<RemoveInvestigator>(_RemoveInvestigator_QNAME,
				RemoveInvestigator.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link DownloadDataset }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "downloadDataset")
	public JAXBElement<DownloadDataset> createDownloadDataset(
			DownloadDataset value) {
		return new JAXBElement<DownloadDataset>(_DownloadDataset_QNAME,
				DownloadDataset.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link AddSampleResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "addSampleResponse")
	public JAXBElement<AddSampleResponse> createAddSampleResponse(
			AddSampleResponse value) {
		return new JAXBElement<AddSampleResponse>(_AddSampleResponse_QNAME,
				AddSampleResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link AddDataFileParameters }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "addDataFileParameters")
	public JAXBElement<AddDataFileParameters> createAddDataFileParameters(
			AddDataFileParameters value) {
		return new JAXBElement<AddDataFileParameters>(
				_AddDataFileParameters_QNAME, AddDataFileParameters.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link AddInvestigatorResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "addInvestigatorResponse")
	public JAXBElement<AddInvestigatorResponse> createAddInvestigatorResponse(
			AddInvestigatorResponse value) {
		return new JAXBElement<AddInvestigatorResponse>(
				_AddInvestigatorResponse_QNAME, AddInvestigatorResponse.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "loginResponse")
	public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
		return new JAXBElement<LoginResponse>(_LoginResponse_QNAME,
				LoginResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ValidationException }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "ValidationException")
	public JAXBElement<ValidationException> createValidationException(
			ValidationException value) {
		return new JAXBElement<ValidationException>(_ValidationException_QNAME,
				ValidationException.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link RemoveAuthorisation }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "removeAuthorisation")
	public JAXBElement<RemoveAuthorisation> createRemoveAuthorisation(
			RemoveAuthorisation value) {
		return new JAXBElement<RemoveAuthorisation>(_RemoveAuthorisation_QNAME,
				RemoveAuthorisation.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetMyInvestigationsIncludesResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "getMyInvestigationsIncludesResponse")
	public JAXBElement<GetMyInvestigationsIncludesResponse> createGetMyInvestigationsIncludesResponse(
			GetMyInvestigationsIncludesResponse value) {
		return new JAXBElement<GetMyInvestigationsIncludesResponse>(
				_GetMyInvestigationsIncludesResponse_QNAME,
				GetMyInvestigationsIncludesResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link SearchDatasetsBySampleResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "searchDatasetsBySampleResponse")
	public JAXBElement<SearchDatasetsBySampleResponse> createSearchDatasetsBySampleResponse(
			SearchDatasetsBySampleResponse value) {
		return new JAXBElement<SearchDatasetsBySampleResponse>(
				_SearchDatasetsBySampleResponse_QNAME,
				SearchDatasetsBySampleResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link DeleteDataFileResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "deleteDataFileResponse")
	public JAXBElement<DeleteDataFileResponse> createDeleteDataFileResponse(
			DeleteDataFileResponse value) {
		return new JAXBElement<DeleteDataFileResponse>(
				_DeleteDataFileResponse_QNAME, DeleteDataFileResponse.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link RemoveDataSetParameterResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "removeDataSetParameterResponse")
	public JAXBElement<RemoveDataSetParameterResponse> createRemoveDataSetParameterResponse(
			RemoveDataSetParameterResponse value) {
		return new JAXBElement<RemoveDataSetParameterResponse>(
				_RemoveDataSetParameterResponse_QNAME,
				RemoveDataSetParameterResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link SearchByAdvancedResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "searchByAdvancedResponse")
	public JAXBElement<SearchByAdvancedResponse> createSearchByAdvancedResponse(
			SearchByAdvancedResponse value) {
		return new JAXBElement<SearchByAdvancedResponse>(
				_SearchByAdvancedResponse_QNAME,
				SearchByAdvancedResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link RemoveSample }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "removeSample")
	public JAXBElement<RemoveSample> createRemoveSample(RemoveSample value) {
		return new JAXBElement<RemoveSample>(_RemoveSample_QNAME,
				RemoveSample.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link ListInstruments }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "listInstruments")
	public JAXBElement<ListInstruments> createListInstruments(
			ListInstruments value) {
		return new JAXBElement<ListInstruments>(_ListInstruments_QNAME,
				ListInstruments.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ListRolesResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "listRolesResponse")
	public JAXBElement<ListRolesResponse> createListRolesResponse(
			ListRolesResponse value) {
		return new JAXBElement<ListRolesResponse>(_ListRolesResponse_QNAME,
				ListRolesResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link CreateDataSetResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "createDataSetResponse")
	public JAXBElement<CreateDataSetResponse> createCreateDataSetResponse(
			CreateDataSetResponse value) {
		return new JAXBElement<CreateDataSetResponse>(
				_CreateDataSetResponse_QNAME, CreateDataSetResponse.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link DownloadDatafileResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "downloadDatafileResponse")
	public JAXBElement<DownloadDatafileResponse> createDownloadDatafileResponse(
			DownloadDatafileResponse value) {
		return new JAXBElement<DownloadDatafileResponse>(
				_DownloadDatafileResponse_QNAME,
				DownloadDatafileResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ListDatasetTypes }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "listDatasetTypes")
	public JAXBElement<ListDatasetTypes> createListDatasetTypes(
			ListDatasetTypes value) {
		return new JAXBElement<ListDatasetTypes>(_ListDatasetTypes_QNAME,
				ListDatasetTypes.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link RemoveAuthorisationResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "removeAuthorisationResponse")
	public JAXBElement<RemoveAuthorisationResponse> createRemoveAuthorisationResponse(
			RemoveAuthorisationResponse value) {
		return new JAXBElement<RemoveAuthorisationResponse>(
				_RemoveAuthorisationResponse_QNAME,
				RemoveAuthorisationResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link SearchByUserID }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "searchByUserID")
	public JAXBElement<SearchByUserID> createSearchByUserID(SearchByUserID value) {
		return new JAXBElement<SearchByUserID>(_SearchByUserID_QNAME,
				SearchByUserID.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetDatasetIncludesResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "getDatasetIncludesResponse")
	public JAXBElement<GetDatasetIncludesResponse> createGetDatasetIncludesResponse(
			GetDatasetIncludesResponse value) {
		return new JAXBElement<GetDatasetIncludesResponse>(
				_GetDatasetIncludesResponse_QNAME,
				GetDatasetIncludesResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link SearchSamplesBySampleNameResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "searchSamplesBySampleNameResponse")
	public JAXBElement<SearchSamplesBySampleNameResponse> createSearchSamplesBySampleNameResponse(
			SearchSamplesBySampleNameResponse value) {
		return new JAXBElement<SearchSamplesBySampleNameResponse>(
				_SearchSamplesBySampleNameResponse_QNAME,
				SearchSamplesBySampleNameResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link AddDataSetParameterResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "addDataSetParameterResponse")
	public JAXBElement<AddDataSetParameterResponse> createAddDataSetParameterResponse(
			AddDataSetParameterResponse value) {
		return new JAXBElement<AddDataSetParameterResponse>(
				_AddDataSetParameterResponse_QNAME,
				AddDataSetParameterResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link SearchByUserSurnamePagination }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "searchByUserSurnamePagination")
	public JAXBElement<SearchByUserSurnamePagination> createSearchByUserSurnamePagination(
			SearchByUserSurnamePagination value) {
		return new JAXBElement<SearchByUserSurnamePagination>(
				_SearchByUserSurnamePagination_QNAME,
				SearchByUserSurnamePagination.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link AddSampleParameterResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "addSampleParameterResponse")
	public JAXBElement<AddSampleParameterResponse> createAddSampleParameterResponse(
			AddSampleParameterResponse value) {
		return new JAXBElement<AddSampleParameterResponse>(
				_AddSampleParameterResponse_QNAME,
				AddSampleParameterResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link DownloadDatafilesResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "downloadDatafilesResponse")
	public JAXBElement<DownloadDatafilesResponse> createDownloadDatafilesResponse(
			DownloadDatafilesResponse value) {
		return new JAXBElement<DownloadDatafilesResponse>(
				_DownloadDatafilesResponse_QNAME,
				DownloadDatafilesResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link SearchByUserSurnamePaginationResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "searchByUserSurnamePaginationResponse")
	public JAXBElement<SearchByUserSurnamePaginationResponse> createSearchByUserSurnamePaginationResponse(
			SearchByUserSurnamePaginationResponse value) {
		return new JAXBElement<SearchByUserSurnamePaginationResponse>(
				_SearchByUserSurnamePaginationResponse_QNAME,
				SearchByUserSurnamePaginationResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link DeleteDataFile }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "deleteDataFile")
	public JAXBElement<DeleteDataFile> createDeleteDataFile(DeleteDataFile value) {
		return new JAXBElement<DeleteDataFile>(_DeleteDataFile_QNAME,
				DeleteDataFile.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetInvestigationResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "getInvestigationResponse")
	public JAXBElement<GetInvestigationResponse> createGetInvestigationResponse(
			GetInvestigationResponse value) {
		return new JAXBElement<GetInvestigationResponse>(
				_GetInvestigationResponse_QNAME,
				GetInvestigationResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link AddSampleParameter }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "addSampleParameter")
	public JAXBElement<AddSampleParameter> createAddSampleParameter(
			AddSampleParameter value) {
		return new JAXBElement<AddSampleParameter>(_AddSampleParameter_QNAME,
				AddSampleParameter.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link ModifyDataSet }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "modifyDataSet")
	public JAXBElement<ModifyDataSet> createModifyDataSet(ModifyDataSet value) {
		return new JAXBElement<ModifyDataSet>(_ModifyDataSet_QNAME,
				ModifyDataSet.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ModifyDataSetResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "modifyDataSetResponse")
	public JAXBElement<ModifyDataSetResponse> createModifyDataSetResponse(
			ModifyDataSetResponse value) {
		return new JAXBElement<ModifyDataSetResponse>(
				_ModifyDataSetResponse_QNAME, ModifyDataSetResponse.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetInvestigationsIncludesResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "getInvestigationsIncludesResponse")
	public JAXBElement<GetInvestigationsIncludesResponse> createGetInvestigationsIncludesResponse(
			GetInvestigationsIncludesResponse value) {
		return new JAXBElement<GetInvestigationsIncludesResponse>(
				_GetInvestigationsIncludesResponse_QNAME,
				GetInvestigationsIncludesResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link CreateDataSetsResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "createDataSetsResponse")
	public JAXBElement<CreateDataSetsResponse> createCreateDataSetsResponse(
			CreateDataSetsResponse value) {
		return new JAXBElement<CreateDataSetsResponse>(
				_CreateDataSetsResponse_QNAME, CreateDataSetsResponse.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link RemoveDataFileParameterResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "removeDataFileParameterResponse")
	public JAXBElement<RemoveDataFileParameterResponse> createRemoveDataFileParameterResponse(
			RemoveDataFileParameterResponse value) {
		return new JAXBElement<RemoveDataFileParameterResponse>(
				_RemoveDataFileParameterResponse_QNAME,
				RemoveDataFileParameterResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link GetAllKeywords }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "getAllKeywords")
	public JAXBElement<GetAllKeywords> createGetAllKeywords(GetAllKeywords value) {
		return new JAXBElement<GetAllKeywords>(_GetAllKeywords_QNAME,
				GetAllKeywords.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link SearchByUserSurnameResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "client.icat3.uk", name = "searchByUserSurnameResponse")
	public JAXBElement<SearchByUserSurnameResponse> createSearchByUserSurnameResponse(
			SearchByUserSurnameResponse value) {
		return new JAXBElement<SearchByUserSurnameResponse>(
				_SearchByUserSurnameResponse_QNAME,
				SearchByUserSurnameResponse.class, null, value);
	}

}
