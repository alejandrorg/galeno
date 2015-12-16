
package org.tempuri;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import org.datacontract.schemas._2004._07.snapiwcfservice.ArrayOfConcept;
import org.datacontract.schemas._2004._07.snapiwcfservice.ArrayOfDescription;
import org.datacontract.schemas._2004._07.snapiwcfservice.ArrayOfFavourite;
import org.datacontract.schemas._2004._07.snapiwcfservice.ArrayOfICD10Children;
import org.datacontract.schemas._2004._07.snapiwcfservice.ArrayOfICD10Code;
import org.datacontract.schemas._2004._07.snapiwcfservice.ArrayOfICD10Description;
import org.datacontract.schemas._2004._07.snapiwcfservice.ArrayOfMapSet;
import org.datacontract.schemas._2004._07.snapiwcfservice.ArrayOfNeighbour;
import org.datacontract.schemas._2004._07.snapiwcfservice.ArrayOfNeighbourCountResult;
import org.datacontract.schemas._2004._07.snapiwcfservice.ArrayOfRelType;
import org.datacontract.schemas._2004._07.snapiwcfservice.ArrayOfStatus;
import org.datacontract.schemas._2004._07.snapiwcfservice.ArrayOfSubSet;
import org.datacontract.schemas._2004._07.snapiwcfservice.ArrayOfSuffix;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2-hudson-752-
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ISnApiService", targetNamespace = "http://tempuri.org/")
@XmlSeeAlso({
    org.datacontract.schemas._2004._07.snapiwcfservice.ObjectFactory.class,
    org.tempuri.ObjectFactory.class,
    org.datacontract.schemas._2004._07.system_data_objects.ObjectFactory.class,
    com.microsoft.schemas._2003._10.serialization.ObjectFactory.class
})
public interface ISnApiService {


    /**
     * 
     * @param guid
     * @param name
     * @return
     *     returns java.lang.Integer
     */
    @WebMethod(operationName = "CreateFavourite", action = "http://tempuri.org/ISnApiService/CreateFavourite")
    @WebResult(name = "CreateFavouriteResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "CreateFavourite", targetNamespace = "http://tempuri.org/", className = "org.tempuri.CreateFavourite")
    @ResponseWrapper(localName = "CreateFavouriteResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.CreateFavouriteResponse")
    public Integer createFavourite(
        @WebParam(name = "name", targetNamespace = "http://tempuri.org/")
        String name,
        @WebParam(name = "guid", targetNamespace = "http://tempuri.org/")
        String guid);

    /**
     * 
     * @param guid
     * @param id
     * @param flag
     */
    @WebMethod(operationName = "SetFavouritePrivateSharedFlag", action = "http://tempuri.org/ISnApiService/SetFavouritePrivateSharedFlag")
    @RequestWrapper(localName = "SetFavouritePrivateSharedFlag", targetNamespace = "http://tempuri.org/", className = "org.tempuri.SetFavouritePrivateSharedFlag")
    @ResponseWrapper(localName = "SetFavouritePrivateSharedFlagResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.SetFavouritePrivateSharedFlagResponse")
    public void setFavouritePrivateSharedFlag(
        @WebParam(name = "id", targetNamespace = "http://tempuri.org/")
        Integer id,
        @WebParam(name = "flag", targetNamespace = "http://tempuri.org/")
        Integer flag,
        @WebParam(name = "guid", targetNamespace = "http://tempuri.org/")
        String guid);

    /**
     * 
     * @param guid
     * @param id
     */
    @WebMethod(operationName = "DeleteFavourite", action = "http://tempuri.org/ISnApiService/DeleteFavourite")
    @RequestWrapper(localName = "DeleteFavourite", targetNamespace = "http://tempuri.org/", className = "org.tempuri.DeleteFavourite")
    @ResponseWrapper(localName = "DeleteFavouriteResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.DeleteFavouriteResponse")
    public void deleteFavourite(
        @WebParam(name = "id", targetNamespace = "http://tempuri.org/")
        Integer id,
        @WebParam(name = "guid", targetNamespace = "http://tempuri.org/")
        String guid);

    /**
     * 
     * @param guid
     * @param id
     * @param name
     */
    @WebMethod(operationName = "RenameFavourite", action = "http://tempuri.org/ISnApiService/RenameFavourite")
    @RequestWrapper(localName = "RenameFavourite", targetNamespace = "http://tempuri.org/", className = "org.tempuri.RenameFavourite")
    @ResponseWrapper(localName = "RenameFavouriteResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.RenameFavouriteResponse")
    public void renameFavourite(
        @WebParam(name = "id", targetNamespace = "http://tempuri.org/")
        Integer id,
        @WebParam(name = "name", targetNamespace = "http://tempuri.org/")
        String name,
        @WebParam(name = "guid", targetNamespace = "http://tempuri.org/")
        String guid);

    /**
     * 
     * @param orgGuid
     * @param email
     * @param name
     * @param fullName
     * @param country
     * @param userGuid
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "RegisterUser", action = "http://tempuri.org/ISnApiService/RegisterUser")
    @WebResult(name = "RegisterUserResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "RegisterUser", targetNamespace = "http://tempuri.org/", className = "org.tempuri.RegisterUser")
    @ResponseWrapper(localName = "RegisterUserResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.RegisterUserResponse")
    public String registerUser(
        @WebParam(name = "orgGuid", targetNamespace = "http://tempuri.org/")
        String orgGuid,
        @WebParam(name = "userGuid", targetNamespace = "http://tempuri.org/")
        String userGuid,
        @WebParam(name = "name", targetNamespace = "http://tempuri.org/")
        String name,
        @WebParam(name = "fullName", targetNamespace = "http://tempuri.org/")
        String fullName,
        @WebParam(name = "email", targetNamespace = "http://tempuri.org/")
        String email,
        @WebParam(name = "country", targetNamespace = "http://tempuri.org/")
        String country);

    /**
     * 
     * @param orgGuid
     * @param unregisterUserGuid
     * @param userGuid
     */
    @WebMethod(operationName = "UnregisterUser", action = "http://tempuri.org/ISnApiService/UnregisterUser")
    @RequestWrapper(localName = "UnregisterUser", targetNamespace = "http://tempuri.org/", className = "org.tempuri.UnregisterUser")
    @ResponseWrapper(localName = "UnregisterUserResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.UnregisterUserResponse")
    public void unregisterUser(
        @WebParam(name = "orgGuid", targetNamespace = "http://tempuri.org/")
        String orgGuid,
        @WebParam(name = "userGuid", targetNamespace = "http://tempuri.org/")
        String userGuid,
        @WebParam(name = "unregisterUserGuid", targetNamespace = "http://tempuri.org/")
        String unregisterUserGuid);

    /**
     * 
     * @param guid
     * @param conceptId
     * @return
     *     returns org.datacontract.schemas._2004._07.snapiwcfservice.ArrayOfNeighbourCountResult
     */
    @WebMethod(operationName = "GetNeighbourCount", action = "http://tempuri.org/ISnApiService/GetNeighbourCount")
    @WebResult(name = "GetNeighbourCountResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetNeighbourCount", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetNeighbourCount")
    @ResponseWrapper(localName = "GetNeighbourCountResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetNeighbourCountResponse")
    public ArrayOfNeighbourCountResult getNeighbourCount(
        @WebParam(name = "conceptId", targetNamespace = "http://tempuri.org/")
        Long conceptId,
        @WebParam(name = "guid", targetNamespace = "http://tempuri.org/")
        String guid);

    /**
     * 
     * @param guid
     * @return
     *     returns org.datacontract.schemas._2004._07.snapiwcfservice.ArrayOfRelType
     */
    @WebMethod(operationName = "GetRelTypes", action = "http://tempuri.org/ISnApiService/GetRelTypes")
    @WebResult(name = "GetRelTypesResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetRelTypes", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetRelTypes")
    @ResponseWrapper(localName = "GetRelTypesResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetRelTypesResponse")
    public ArrayOfRelType getRelTypes(
        @WebParam(name = "guid", targetNamespace = "http://tempuri.org/")
        String guid);

    /**
     * 
     * @param guid
     * @return
     *     returns org.datacontract.schemas._2004._07.snapiwcfservice.ArrayOfMapSet
     */
    @WebMethod(operationName = "GetCrossMapSet", action = "http://tempuri.org/ISnApiService/GetCrossMapSet")
    @WebResult(name = "GetCrossMapSetResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetCrossMapSet", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetCrossMapSet")
    @ResponseWrapper(localName = "GetCrossMapSetResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetCrossMapSetResponse")
    public ArrayOfMapSet getCrossMapSet(
        @WebParam(name = "guid", targetNamespace = "http://tempuri.org/")
        String guid);

    /**
     * 
     * @param guid
     * @return
     *     returns org.datacontract.schemas._2004._07.snapiwcfservice.ArrayOfStatus
     */
    @WebMethod(operationName = "GetStatus", action = "http://tempuri.org/ISnApiService/GetStatus")
    @WebResult(name = "GetStatusResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetStatus", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetStatus")
    @ResponseWrapper(localName = "GetStatusResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetStatusResponse")
    public ArrayOfStatus getStatus(
        @WebParam(name = "guid", targetNamespace = "http://tempuri.org/")
        String guid);

    /**
     * 
     * @param guid
     * @return
     *     returns org.datacontract.schemas._2004._07.snapiwcfservice.ArrayOfSuffix
     */
    @WebMethod(operationName = "GetSuffixes", action = "http://tempuri.org/ISnApiService/GetSuffixes")
    @WebResult(name = "GetSuffixesResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetSuffixes", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetSuffixes")
    @ResponseWrapper(localName = "GetSuffixesResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetSuffixesResponse")
    public ArrayOfSuffix getSuffixes(
        @WebParam(name = "guid", targetNamespace = "http://tempuri.org/")
        String guid);

    /**
     * 
     * @param guid
     * @param showEmpty
     * @param includeShared
     * @return
     *     returns org.datacontract.schemas._2004._07.snapiwcfservice.ArrayOfFavourite
     */
    @WebMethod(operationName = "GetFavourites", action = "http://tempuri.org/ISnApiService/GetFavourites")
    @WebResult(name = "GetFavouritesResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetFavourites", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetFavourites")
    @ResponseWrapper(localName = "GetFavouritesResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetFavouritesResponse")
    public ArrayOfFavourite getFavourites(
        @WebParam(name = "showEmpty", targetNamespace = "http://tempuri.org/")
        String showEmpty,
        @WebParam(name = "includeShared", targetNamespace = "http://tempuri.org/")
        String includeShared,
        @WebParam(name = "guid", targetNamespace = "http://tempuri.org/")
        String guid);

    /**
     * 
     * @param guid
     * @return
     *     returns org.datacontract.schemas._2004._07.snapiwcfservice.ArrayOfSubSet
     */
    @WebMethod(operationName = "GetSubSets", action = "http://tempuri.org/ISnApiService/GetSubSets")
    @WebResult(name = "GetSubSetsResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetSubSets", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetSubSets")
    @ResponseWrapper(localName = "GetSubSetsResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetSubSetsResponse")
    public ArrayOfSubSet getSubSets(
        @WebParam(name = "guid", targetNamespace = "http://tempuri.org/")
        String guid);

    /**
     * 
     * @param text
     * @param status
     * @param matchType
     * @param favorites
     * @param suffix
     * @param namespaces
     * @param maxResults
     * @param guid
     * @param subsets
     * @param targetCodes
     * @param ancestorId
     * @param mapSetId
     * @param searchMode
     * @param descendentId
     * @param saveToFavouriteId
     * @return
     *     returns org.datacontract.schemas._2004._07.snapiwcfservice.ArrayOfConcept
     */
    @WebMethod(operationName = "SearchConcepts", action = "http://tempuri.org/ISnApiService/SearchConcepts")
    @WebResult(name = "SearchConceptsResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "SearchConcepts", targetNamespace = "http://tempuri.org/", className = "org.tempuri.SearchConcepts")
    @ResponseWrapper(localName = "SearchConceptsResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.SearchConceptsResponse")
    public ArrayOfConcept searchConcepts(
        @WebParam(name = "text", targetNamespace = "http://tempuri.org/")
        String text,
        @WebParam(name = "descendentId", targetNamespace = "http://tempuri.org/")
        String descendentId,
        @WebParam(name = "status", targetNamespace = "http://tempuri.org/")
        String status,
        @WebParam(name = "ancestorId", targetNamespace = "http://tempuri.org/")
        String ancestorId,
        @WebParam(name = "saveToFavouriteId", targetNamespace = "http://tempuri.org/")
        String saveToFavouriteId,
        @WebParam(name = "targetCodes", targetNamespace = "http://tempuri.org/")
        String targetCodes,
        @WebParam(name = "mapSetId", targetNamespace = "http://tempuri.org/")
        String mapSetId,
        @WebParam(name = "subsets", targetNamespace = "http://tempuri.org/")
        String subsets,
        @WebParam(name = "favorites", targetNamespace = "http://tempuri.org/")
        String favorites,
        @WebParam(name = "suffix", targetNamespace = "http://tempuri.org/")
        String suffix,
        @WebParam(name = "namespaces", targetNamespace = "http://tempuri.org/")
        String namespaces,
        @WebParam(name = "maxResults", targetNamespace = "http://tempuri.org/")
        Integer maxResults,
        @WebParam(name = "matchType", targetNamespace = "http://tempuri.org/")
        Integer matchType,
        @WebParam(name = "searchMode", targetNamespace = "http://tempuri.org/")
        String searchMode,
        @WebParam(name = "guid", targetNamespace = "http://tempuri.org/")
        String guid);

    /**
     * 
     * @param guid
     * @param text
     * @param matchType
     * @param searchMode
     * @param maxResults
     * @return
     *     returns org.datacontract.schemas._2004._07.snapiwcfservice.ArrayOfICD10Code
     */
    @WebMethod(operationName = "SearchICD10Codes", action = "http://tempuri.org/ISnApiService/SearchICD10Codes")
    @WebResult(name = "SearchICD10CodesResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "SearchICD10Codes", targetNamespace = "http://tempuri.org/", className = "org.tempuri.SearchICD10Codes")
    @ResponseWrapper(localName = "SearchICD10CodesResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.SearchICD10CodesResponse")
    public ArrayOfICD10Code searchICD10Codes(
        @WebParam(name = "text", targetNamespace = "http://tempuri.org/")
        String text,
        @WebParam(name = "maxResults", targetNamespace = "http://tempuri.org/")
        Integer maxResults,
        @WebParam(name = "matchType", targetNamespace = "http://tempuri.org/")
        Integer matchType,
        @WebParam(name = "SearchMode", targetNamespace = "http://tempuri.org/")
        String searchMode,
        @WebParam(name = "guid", targetNamespace = "http://tempuri.org/")
        String guid);

    /**
     * 
     * @param guid
     * @param subsets
     * @param targetCodes
     * @param text
     * @param status
     * @param matchType
     * @param ancestorId
     * @param favorites
     * @param mapSetId
     * @param namespaces
     * @param suffix
     * @param descendentId
     * @return
     *     returns java.lang.Integer
     */
    @WebMethod(operationName = "SearchConceptsCount", action = "http://tempuri.org/ISnApiService/SearchConceptsCount")
    @WebResult(name = "SearchConceptsCountResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "SearchConceptsCount", targetNamespace = "http://tempuri.org/", className = "org.tempuri.SearchConceptsCount")
    @ResponseWrapper(localName = "SearchConceptsCountResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.SearchConceptsCountResponse")
    public Integer searchConceptsCount(
        @WebParam(name = "text", targetNamespace = "http://tempuri.org/")
        String text,
        @WebParam(name = "descendentId", targetNamespace = "http://tempuri.org/")
        String descendentId,
        @WebParam(name = "status", targetNamespace = "http://tempuri.org/")
        String status,
        @WebParam(name = "ancestorId", targetNamespace = "http://tempuri.org/")
        String ancestorId,
        @WebParam(name = "targetCodes", targetNamespace = "http://tempuri.org/")
        String targetCodes,
        @WebParam(name = "mapSetId", targetNamespace = "http://tempuri.org/")
        String mapSetId,
        @WebParam(name = "subsets", targetNamespace = "http://tempuri.org/")
        String subsets,
        @WebParam(name = "favorites", targetNamespace = "http://tempuri.org/")
        String favorites,
        @WebParam(name = "suffix", targetNamespace = "http://tempuri.org/")
        String suffix,
        @WebParam(name = "namespaces", targetNamespace = "http://tempuri.org/")
        String namespaces,
        @WebParam(name = "matchType", targetNamespace = "http://tempuri.org/")
        Integer matchType,
        @WebParam(name = "guid", targetNamespace = "http://tempuri.org/")
        String guid);

    /**
     * 
     * @param guid
     * @param nameSpace
     * @param conceptId
     * @return
     *     returns org.datacontract.schemas._2004._07.snapiwcfservice.ArrayOfConcept
     */
    @WebMethod(operationName = "GetConcept", action = "http://tempuri.org/ISnApiService/GetConcept")
    @WebResult(name = "GetConceptResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetConcept", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetConcept")
    @ResponseWrapper(localName = "GetConceptResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetConceptResponse")
    public ArrayOfConcept getConcept(
        @WebParam(name = "conceptId", targetNamespace = "http://tempuri.org/")
        String conceptId,
        @WebParam(name = "nameSpace", targetNamespace = "http://tempuri.org/")
        String nameSpace,
        @WebParam(name = "guid", targetNamespace = "http://tempuri.org/")
        String guid);

    /**
     * 
     * @param guid
     * @param conceptId
     * @return
     *     returns org.datacontract.schemas._2004._07.snapiwcfservice.ArrayOfDescription
     */
    @WebMethod(operationName = "GetDescription", action = "http://tempuri.org/ISnApiService/GetDescription")
    @WebResult(name = "GetDescriptionResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetDescription", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetDescription")
    @ResponseWrapper(localName = "GetDescriptionResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetDescriptionResponse")
    public ArrayOfDescription getDescription(
        @WebParam(name = "conceptId", targetNamespace = "http://tempuri.org/")
        Long conceptId,
        @WebParam(name = "guid", targetNamespace = "http://tempuri.org/")
        String guid);

    /**
     * 
     * @param guid
     * @param conceptId
     * @return
     *     returns org.datacontract.schemas._2004._07.snapiwcfservice.ArrayOfICD10Description
     */
    @WebMethod(operationName = "GetICD10Description", action = "http://tempuri.org/ISnApiService/GetICD10Description")
    @WebResult(name = "GetICD10DescriptionResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetICD10Description", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetICD10Description")
    @ResponseWrapper(localName = "GetICD10DescriptionResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetICD10DescriptionResponse")
    public ArrayOfICD10Description getICD10Description(
        @WebParam(name = "conceptId", targetNamespace = "http://tempuri.org/")
        String conceptId,
        @WebParam(name = "guid", targetNamespace = "http://tempuri.org/")
        String guid);

    /**
     * 
     * @param guid
     * @param relType
     * @param nameSpace
     * @param conceptId
     * @return
     *     returns org.datacontract.schemas._2004._07.snapiwcfservice.ArrayOfNeighbour
     */
    @WebMethod(operationName = "GetNeighbours", action = "http://tempuri.org/ISnApiService/GetNeighbours")
    @WebResult(name = "GetNeighboursResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetNeighbours", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetNeighbours")
    @ResponseWrapper(localName = "GetNeighboursResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetNeighboursResponse")
    public ArrayOfNeighbour getNeighbours(
        @WebParam(name = "conceptId", targetNamespace = "http://tempuri.org/")
        Long conceptId,
        @WebParam(name = "nameSpace", targetNamespace = "http://tempuri.org/")
        String nameSpace,
        @WebParam(name = "relType", targetNamespace = "http://tempuri.org/")
        Integer relType,
        @WebParam(name = "guid", targetNamespace = "http://tempuri.org/")
        String guid);

    /**
     * 
     * @param guid
     * @param conceptId
     * @return
     *     returns org.datacontract.schemas._2004._07.snapiwcfservice.ArrayOfICD10Children
     */
    @WebMethod(operationName = "GetICD10Children", action = "http://tempuri.org/ISnApiService/GetICD10Children")
    @WebResult(name = "GetICD10ChildrenResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetICD10Children", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetICD10Children")
    @ResponseWrapper(localName = "GetICD10ChildrenResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetICD10ChildrenResponse")
    public ArrayOfICD10Children getICD10Children(
        @WebParam(name = "conceptId", targetNamespace = "http://tempuri.org/")
        String conceptId,
        @WebParam(name = "guid", targetNamespace = "http://tempuri.org/")
        String guid);

    /**
     * 
     * @param guid
     * @param favouriteId
     * @param action
     * @param keyList
     */
    @WebMethod(operationName = "ManageFavourites", action = "http://tempuri.org/ISnApiService/ManageFavourites")
    @RequestWrapper(localName = "ManageFavourites", targetNamespace = "http://tempuri.org/", className = "org.tempuri.ManageFavourites")
    @ResponseWrapper(localName = "ManageFavouritesResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.ManageFavouritesResponse")
    public void manageFavourites(
        @WebParam(name = "action", targetNamespace = "http://tempuri.org/")
        String action,
        @WebParam(name = "favouriteId", targetNamespace = "http://tempuri.org/")
        Integer favouriteId,
        @WebParam(name = "keyList", targetNamespace = "http://tempuri.org/")
        String keyList,
        @WebParam(name = "guid", targetNamespace = "http://tempuri.org/")
        String guid);

    /**
     * 
     * @param guid
     * @param value
     * @param key
     */
    @WebMethod(operationName = "SetConfigValue", action = "http://tempuri.org/ISnApiService/SetConfigValue")
    @RequestWrapper(localName = "SetConfigValue", targetNamespace = "http://tempuri.org/", className = "org.tempuri.SetConfigValue")
    @ResponseWrapper(localName = "SetConfigValueResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.SetConfigValueResponse")
    public void setConfigValue(
        @WebParam(name = "key", targetNamespace = "http://tempuri.org/")
        String key,
        @WebParam(name = "value", targetNamespace = "http://tempuri.org/")
        String value,
        @WebParam(name = "guid", targetNamespace = "http://tempuri.org/")
        String guid);

    /**
     * 
     * @param guid
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "GetSnoflakeURL", action = "http://tempuri.org/ISnApiService/GetSnoflakeURL")
    @WebResult(name = "GetSnoflakeURLResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetSnoflakeURL", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetSnoflakeURL")
    @ResponseWrapper(localName = "GetSnoflakeURLResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetSnoflakeURLResponse")
    public String getSnoflakeURL(
        @WebParam(name = "guid", targetNamespace = "http://tempuri.org/")
        String guid);

}