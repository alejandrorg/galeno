
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
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
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.tempuri package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetSuffixesResponseGetSuffixesResult_QNAME = new QName("http://tempuri.org/", "GetSuffixesResult");
    private final static QName _RegisterUserName_QNAME = new QName("http://tempuri.org/", "name");
    private final static QName _RegisterUserEmail_QNAME = new QName("http://tempuri.org/", "email");
    private final static QName _RegisterUserOrgGuid_QNAME = new QName("http://tempuri.org/", "orgGuid");
    private final static QName _RegisterUserCountry_QNAME = new QName("http://tempuri.org/", "country");
    private final static QName _RegisterUserUserGuid_QNAME = new QName("http://tempuri.org/", "userGuid");
    private final static QName _RegisterUserFullName_QNAME = new QName("http://tempuri.org/", "fullName");
    private final static QName _GetICD10DescriptionConceptId_QNAME = new QName("http://tempuri.org/", "conceptId");
    private final static QName _GetICD10DescriptionGuid_QNAME = new QName("http://tempuri.org/", "guid");
    private final static QName _GetSubSetsResponseGetSubSetsResult_QNAME = new QName("http://tempuri.org/", "GetSubSetsResult");
    private final static QName _RegisterUserResponseRegisterUserResult_QNAME = new QName("http://tempuri.org/", "RegisterUserResult");
    private final static QName _SearchConceptsCountStatus_QNAME = new QName("http://tempuri.org/", "status");
    private final static QName _SearchConceptsCountTargetCodes_QNAME = new QName("http://tempuri.org/", "targetCodes");
    private final static QName _SearchConceptsCountText_QNAME = new QName("http://tempuri.org/", "text");
    private final static QName _SearchConceptsCountSubsets_QNAME = new QName("http://tempuri.org/", "subsets");
    private final static QName _SearchConceptsCountDescendentId_QNAME = new QName("http://tempuri.org/", "descendentId");
    private final static QName _SearchConceptsCountNamespaces_QNAME = new QName("http://tempuri.org/", "namespaces");
    private final static QName _SearchConceptsCountSuffix_QNAME = new QName("http://tempuri.org/", "suffix");
    private final static QName _SearchConceptsCountMapSetId_QNAME = new QName("http://tempuri.org/", "mapSetId");
    private final static QName _SearchConceptsCountFavorites_QNAME = new QName("http://tempuri.org/", "favorites");
    private final static QName _SearchConceptsCountAncestorId_QNAME = new QName("http://tempuri.org/", "ancestorId");
    private final static QName _SearchICD10CodesSearchMode_QNAME = new QName("http://tempuri.org/", "SearchMode");
    private final static QName _GetFavouritesShowEmpty_QNAME = new QName("http://tempuri.org/", "showEmpty");
    private final static QName _GetFavouritesIncludeShared_QNAME = new QName("http://tempuri.org/", "includeShared");
    private final static QName _GetNeighboursResponseGetNeighboursResult_QNAME = new QName("http://tempuri.org/", "GetNeighboursResult");
    private final static QName _ManageFavouritesKeyList_QNAME = new QName("http://tempuri.org/", "keyList");
    private final static QName _ManageFavouritesAction_QNAME = new QName("http://tempuri.org/", "action");
    private final static QName _GetConceptResponseGetConceptResult_QNAME = new QName("http://tempuri.org/", "GetConceptResult");
    private final static QName _GetCrossMapSetResponseGetCrossMapSetResult_QNAME = new QName("http://tempuri.org/", "GetCrossMapSetResult");
    private final static QName _GetFavouritesResponseGetFavouritesResult_QNAME = new QName("http://tempuri.org/", "GetFavouritesResult");
    private final static QName _GetICD10ChildrenResponseGetICD10ChildrenResult_QNAME = new QName("http://tempuri.org/", "GetICD10ChildrenResult");
    private final static QName _GetConceptNameSpace_QNAME = new QName("http://tempuri.org/", "nameSpace");
    private final static QName _SetConfigValueKey_QNAME = new QName("http://tempuri.org/", "key");
    private final static QName _SetConfigValueValue_QNAME = new QName("http://tempuri.org/", "value");
    private final static QName _GetICD10DescriptionResponseGetICD10DescriptionResult_QNAME = new QName("http://tempuri.org/", "GetICD10DescriptionResult");
    private final static QName _SearchConceptsResponseSearchConceptsResult_QNAME = new QName("http://tempuri.org/", "SearchConceptsResult");
    private final static QName _GetRelTypesResponseGetRelTypesResult_QNAME = new QName("http://tempuri.org/", "GetRelTypesResult");
    private final static QName _SearchICD10CodesResponseSearchICD10CodesResult_QNAME = new QName("http://tempuri.org/", "SearchICD10CodesResult");
    private final static QName _GetSnoflakeURLResponseGetSnoflakeURLResult_QNAME = new QName("http://tempuri.org/", "GetSnoflakeURLResult");
    private final static QName _GetStatusResponseGetStatusResult_QNAME = new QName("http://tempuri.org/", "GetStatusResult");
    private final static QName _SearchConceptsSaveToFavouriteId_QNAME = new QName("http://tempuri.org/", "saveToFavouriteId");
    private final static QName _SearchConceptsSearchMode_QNAME = new QName("http://tempuri.org/", "searchMode");
    private final static QName _GetNeighbourCountResponseGetNeighbourCountResult_QNAME = new QName("http://tempuri.org/", "GetNeighbourCountResult");
    private final static QName _GetDescriptionResponseGetDescriptionResult_QNAME = new QName("http://tempuri.org/", "GetDescriptionResult");
    private final static QName _UnregisterUserUnregisterUserGuid_QNAME = new QName("http://tempuri.org/", "unregisterUserGuid");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.tempuri
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetSuffixesResponse }
     * 
     */
    public GetSuffixesResponse createGetSuffixesResponse() {
        return new GetSuffixesResponse();
    }

    /**
     * Create an instance of {@link GetICD10Description }
     * 
     */
    public GetICD10Description createGetICD10Description() {
        return new GetICD10Description();
    }

    /**
     * Create an instance of {@link RegisterUser }
     * 
     */
    public RegisterUser createRegisterUser() {
        return new RegisterUser();
    }

    /**
     * Create an instance of {@link GetSubSetsResponse }
     * 
     */
    public GetSubSetsResponse createGetSubSetsResponse() {
        return new GetSubSetsResponse();
    }

    /**
     * Create an instance of {@link RegisterUserResponse }
     * 
     */
    public RegisterUserResponse createRegisterUserResponse() {
        return new RegisterUserResponse();
    }

    /**
     * Create an instance of {@link SearchConceptsCount }
     * 
     */
    public SearchConceptsCount createSearchConceptsCount() {
        return new SearchConceptsCount();
    }

    /**
     * Create an instance of {@link CreateFavouriteResponse }
     * 
     */
    public CreateFavouriteResponse createCreateFavouriteResponse() {
        return new CreateFavouriteResponse();
    }

    /**
     * Create an instance of {@link SearchICD10Codes }
     * 
     */
    public SearchICD10Codes createSearchICD10Codes() {
        return new SearchICD10Codes();
    }

    /**
     * Create an instance of {@link SearchConceptsCountResponse }
     * 
     */
    public SearchConceptsCountResponse createSearchConceptsCountResponse() {
        return new SearchConceptsCountResponse();
    }

    /**
     * Create an instance of {@link SetConfigValueResponse }
     * 
     */
    public SetConfigValueResponse createSetConfigValueResponse() {
        return new SetConfigValueResponse();
    }

    /**
     * Create an instance of {@link GetNeighbourCount }
     * 
     */
    public GetNeighbourCount createGetNeighbourCount() {
        return new GetNeighbourCount();
    }

    /**
     * Create an instance of {@link GetFavourites }
     * 
     */
    public GetFavourites createGetFavourites() {
        return new GetFavourites();
    }

    /**
     * Create an instance of {@link GetNeighboursResponse }
     * 
     */
    public GetNeighboursResponse createGetNeighboursResponse() {
        return new GetNeighboursResponse();
    }

    /**
     * Create an instance of {@link ManageFavourites }
     * 
     */
    public ManageFavourites createManageFavourites() {
        return new ManageFavourites();
    }

    /**
     * Create an instance of {@link GetConceptResponse }
     * 
     */
    public GetConceptResponse createGetConceptResponse() {
        return new GetConceptResponse();
    }

    /**
     * Create an instance of {@link GetICD10Children }
     * 
     */
    public GetICD10Children createGetICD10Children() {
        return new GetICD10Children();
    }

    /**
     * Create an instance of {@link GetSnoflakeURL }
     * 
     */
    public GetSnoflakeURL createGetSnoflakeURL() {
        return new GetSnoflakeURL();
    }

    /**
     * Create an instance of {@link ManageFavouritesResponse }
     * 
     */
    public ManageFavouritesResponse createManageFavouritesResponse() {
        return new ManageFavouritesResponse();
    }

    /**
     * Create an instance of {@link GetCrossMapSetResponse }
     * 
     */
    public GetCrossMapSetResponse createGetCrossMapSetResponse() {
        return new GetCrossMapSetResponse();
    }

    /**
     * Create an instance of {@link GetRelTypes }
     * 
     */
    public GetRelTypes createGetRelTypes() {
        return new GetRelTypes();
    }

    /**
     * Create an instance of {@link GetFavouritesResponse }
     * 
     */
    public GetFavouritesResponse createGetFavouritesResponse() {
        return new GetFavouritesResponse();
    }

    /**
     * Create an instance of {@link CreateFavourite }
     * 
     */
    public CreateFavourite createCreateFavourite() {
        return new CreateFavourite();
    }

    /**
     * Create an instance of {@link GetStatus }
     * 
     */
    public GetStatus createGetStatus() {
        return new GetStatus();
    }

    /**
     * Create an instance of {@link GetICD10ChildrenResponse }
     * 
     */
    public GetICD10ChildrenResponse createGetICD10ChildrenResponse() {
        return new GetICD10ChildrenResponse();
    }

    /**
     * Create an instance of {@link GetDescription }
     * 
     */
    public GetDescription createGetDescription() {
        return new GetDescription();
    }

    /**
     * Create an instance of {@link RenameFavouriteResponse }
     * 
     */
    public RenameFavouriteResponse createRenameFavouriteResponse() {
        return new RenameFavouriteResponse();
    }

    /**
     * Create an instance of {@link GetConcept }
     * 
     */
    public GetConcept createGetConcept() {
        return new GetConcept();
    }

    /**
     * Create an instance of {@link SetConfigValue }
     * 
     */
    public SetConfigValue createSetConfigValue() {
        return new SetConfigValue();
    }

    /**
     * Create an instance of {@link UnregisterUserResponse }
     * 
     */
    public UnregisterUserResponse createUnregisterUserResponse() {
        return new UnregisterUserResponse();
    }

    /**
     * Create an instance of {@link GetICD10DescriptionResponse }
     * 
     */
    public GetICD10DescriptionResponse createGetICD10DescriptionResponse() {
        return new GetICD10DescriptionResponse();
    }

    /**
     * Create an instance of {@link SearchConceptsResponse }
     * 
     */
    public SearchConceptsResponse createSearchConceptsResponse() {
        return new SearchConceptsResponse();
    }

    /**
     * Create an instance of {@link GetSubSets }
     * 
     */
    public GetSubSets createGetSubSets() {
        return new GetSubSets();
    }

    /**
     * Create an instance of {@link SetFavouritePrivateSharedFlagResponse }
     * 
     */
    public SetFavouritePrivateSharedFlagResponse createSetFavouritePrivateSharedFlagResponse() {
        return new SetFavouritePrivateSharedFlagResponse();
    }

    /**
     * Create an instance of {@link GetRelTypesResponse }
     * 
     */
    public GetRelTypesResponse createGetRelTypesResponse() {
        return new GetRelTypesResponse();
    }

    /**
     * Create an instance of {@link DeleteFavouriteResponse }
     * 
     */
    public DeleteFavouriteResponse createDeleteFavouriteResponse() {
        return new DeleteFavouriteResponse();
    }

    /**
     * Create an instance of {@link SearchICD10CodesResponse }
     * 
     */
    public SearchICD10CodesResponse createSearchICD10CodesResponse() {
        return new SearchICD10CodesResponse();
    }

    /**
     * Create an instance of {@link GetSuffixes }
     * 
     */
    public GetSuffixes createGetSuffixes() {
        return new GetSuffixes();
    }

    /**
     * Create an instance of {@link SetFavouritePrivateSharedFlag }
     * 
     */
    public SetFavouritePrivateSharedFlag createSetFavouritePrivateSharedFlag() {
        return new SetFavouritePrivateSharedFlag();
    }

    /**
     * Create an instance of {@link GetStatusResponse }
     * 
     */
    public GetStatusResponse createGetStatusResponse() {
        return new GetStatusResponse();
    }

    /**
     * Create an instance of {@link GetSnoflakeURLResponse }
     * 
     */
    public GetSnoflakeURLResponse createGetSnoflakeURLResponse() {
        return new GetSnoflakeURLResponse();
    }

    /**
     * Create an instance of {@link DeleteFavourite }
     * 
     */
    public DeleteFavourite createDeleteFavourite() {
        return new DeleteFavourite();
    }

    /**
     * Create an instance of {@link RenameFavourite }
     * 
     */
    public RenameFavourite createRenameFavourite() {
        return new RenameFavourite();
    }

    /**
     * Create an instance of {@link SearchConcepts }
     * 
     */
    public SearchConcepts createSearchConcepts() {
        return new SearchConcepts();
    }

    /**
     * Create an instance of {@link GetNeighbours }
     * 
     */
    public GetNeighbours createGetNeighbours() {
        return new GetNeighbours();
    }

    /**
     * Create an instance of {@link GetCrossMapSet }
     * 
     */
    public GetCrossMapSet createGetCrossMapSet() {
        return new GetCrossMapSet();
    }

    /**
     * Create an instance of {@link GetNeighbourCountResponse }
     * 
     */
    public GetNeighbourCountResponse createGetNeighbourCountResponse() {
        return new GetNeighbourCountResponse();
    }

    /**
     * Create an instance of {@link GetDescriptionResponse }
     * 
     */
    public GetDescriptionResponse createGetDescriptionResponse() {
        return new GetDescriptionResponse();
    }

    /**
     * Create an instance of {@link UnregisterUser }
     * 
     */
    public UnregisterUser createUnregisterUser() {
        return new UnregisterUser();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfSuffix }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetSuffixesResult", scope = GetSuffixesResponse.class)
    public JAXBElement<ArrayOfSuffix> createGetSuffixesResponseGetSuffixesResult(ArrayOfSuffix value) {
        return new JAXBElement<ArrayOfSuffix>(_GetSuffixesResponseGetSuffixesResult_QNAME, ArrayOfSuffix.class, GetSuffixesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "name", scope = RegisterUser.class)
    public JAXBElement<String> createRegisterUserName(String value) {
        return new JAXBElement<String>(_RegisterUserName_QNAME, String.class, RegisterUser.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "email", scope = RegisterUser.class)
    public JAXBElement<String> createRegisterUserEmail(String value) {
        return new JAXBElement<String>(_RegisterUserEmail_QNAME, String.class, RegisterUser.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "orgGuid", scope = RegisterUser.class)
    public JAXBElement<String> createRegisterUserOrgGuid(String value) {
        return new JAXBElement<String>(_RegisterUserOrgGuid_QNAME, String.class, RegisterUser.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "country", scope = RegisterUser.class)
    public JAXBElement<String> createRegisterUserCountry(String value) {
        return new JAXBElement<String>(_RegisterUserCountry_QNAME, String.class, RegisterUser.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "userGuid", scope = RegisterUser.class)
    public JAXBElement<String> createRegisterUserUserGuid(String value) {
        return new JAXBElement<String>(_RegisterUserUserGuid_QNAME, String.class, RegisterUser.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "fullName", scope = RegisterUser.class)
    public JAXBElement<String> createRegisterUserFullName(String value) {
        return new JAXBElement<String>(_RegisterUserFullName_QNAME, String.class, RegisterUser.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "conceptId", scope = GetICD10Description.class)
    public JAXBElement<String> createGetICD10DescriptionConceptId(String value) {
        return new JAXBElement<String>(_GetICD10DescriptionConceptId_QNAME, String.class, GetICD10Description.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "guid", scope = GetICD10Description.class)
    public JAXBElement<String> createGetICD10DescriptionGuid(String value) {
        return new JAXBElement<String>(_GetICD10DescriptionGuid_QNAME, String.class, GetICD10Description.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfSubSet }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetSubSetsResult", scope = GetSubSetsResponse.class)
    public JAXBElement<ArrayOfSubSet> createGetSubSetsResponseGetSubSetsResult(ArrayOfSubSet value) {
        return new JAXBElement<ArrayOfSubSet>(_GetSubSetsResponseGetSubSetsResult_QNAME, ArrayOfSubSet.class, GetSubSetsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "RegisterUserResult", scope = RegisterUserResponse.class)
    public JAXBElement<String> createRegisterUserResponseRegisterUserResult(String value) {
        return new JAXBElement<String>(_RegisterUserResponseRegisterUserResult_QNAME, String.class, RegisterUserResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "status", scope = SearchConceptsCount.class)
    public JAXBElement<String> createSearchConceptsCountStatus(String value) {
        return new JAXBElement<String>(_SearchConceptsCountStatus_QNAME, String.class, SearchConceptsCount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "targetCodes", scope = SearchConceptsCount.class)
    public JAXBElement<String> createSearchConceptsCountTargetCodes(String value) {
        return new JAXBElement<String>(_SearchConceptsCountTargetCodes_QNAME, String.class, SearchConceptsCount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "text", scope = SearchConceptsCount.class)
    public JAXBElement<String> createSearchConceptsCountText(String value) {
        return new JAXBElement<String>(_SearchConceptsCountText_QNAME, String.class, SearchConceptsCount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "guid", scope = SearchConceptsCount.class)
    public JAXBElement<String> createSearchConceptsCountGuid(String value) {
        return new JAXBElement<String>(_GetICD10DescriptionGuid_QNAME, String.class, SearchConceptsCount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "subsets", scope = SearchConceptsCount.class)
    public JAXBElement<String> createSearchConceptsCountSubsets(String value) {
        return new JAXBElement<String>(_SearchConceptsCountSubsets_QNAME, String.class, SearchConceptsCount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "descendentId", scope = SearchConceptsCount.class)
    public JAXBElement<String> createSearchConceptsCountDescendentId(String value) {
        return new JAXBElement<String>(_SearchConceptsCountDescendentId_QNAME, String.class, SearchConceptsCount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "namespaces", scope = SearchConceptsCount.class)
    public JAXBElement<String> createSearchConceptsCountNamespaces(String value) {
        return new JAXBElement<String>(_SearchConceptsCountNamespaces_QNAME, String.class, SearchConceptsCount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "suffix", scope = SearchConceptsCount.class)
    public JAXBElement<String> createSearchConceptsCountSuffix(String value) {
        return new JAXBElement<String>(_SearchConceptsCountSuffix_QNAME, String.class, SearchConceptsCount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "mapSetId", scope = SearchConceptsCount.class)
    public JAXBElement<String> createSearchConceptsCountMapSetId(String value) {
        return new JAXBElement<String>(_SearchConceptsCountMapSetId_QNAME, String.class, SearchConceptsCount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "favorites", scope = SearchConceptsCount.class)
    public JAXBElement<String> createSearchConceptsCountFavorites(String value) {
        return new JAXBElement<String>(_SearchConceptsCountFavorites_QNAME, String.class, SearchConceptsCount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ancestorId", scope = SearchConceptsCount.class)
    public JAXBElement<String> createSearchConceptsCountAncestorId(String value) {
        return new JAXBElement<String>(_SearchConceptsCountAncestorId_QNAME, String.class, SearchConceptsCount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "text", scope = SearchICD10Codes.class)
    public JAXBElement<String> createSearchICD10CodesText(String value) {
        return new JAXBElement<String>(_SearchConceptsCountText_QNAME, String.class, SearchICD10Codes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "guid", scope = SearchICD10Codes.class)
    public JAXBElement<String> createSearchICD10CodesGuid(String value) {
        return new JAXBElement<String>(_GetICD10DescriptionGuid_QNAME, String.class, SearchICD10Codes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "SearchMode", scope = SearchICD10Codes.class)
    public JAXBElement<String> createSearchICD10CodesSearchMode(String value) {
        return new JAXBElement<String>(_SearchICD10CodesSearchMode_QNAME, String.class, SearchICD10Codes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "guid", scope = GetNeighbourCount.class)
    public JAXBElement<String> createGetNeighbourCountGuid(String value) {
        return new JAXBElement<String>(_GetICD10DescriptionGuid_QNAME, String.class, GetNeighbourCount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "showEmpty", scope = GetFavourites.class)
    public JAXBElement<String> createGetFavouritesShowEmpty(String value) {
        return new JAXBElement<String>(_GetFavouritesShowEmpty_QNAME, String.class, GetFavourites.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "guid", scope = GetFavourites.class)
    public JAXBElement<String> createGetFavouritesGuid(String value) {
        return new JAXBElement<String>(_GetICD10DescriptionGuid_QNAME, String.class, GetFavourites.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "includeShared", scope = GetFavourites.class)
    public JAXBElement<String> createGetFavouritesIncludeShared(String value) {
        return new JAXBElement<String>(_GetFavouritesIncludeShared_QNAME, String.class, GetFavourites.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfNeighbour }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetNeighboursResult", scope = GetNeighboursResponse.class)
    public JAXBElement<ArrayOfNeighbour> createGetNeighboursResponseGetNeighboursResult(ArrayOfNeighbour value) {
        return new JAXBElement<ArrayOfNeighbour>(_GetNeighboursResponseGetNeighboursResult_QNAME, ArrayOfNeighbour.class, GetNeighboursResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "guid", scope = ManageFavourites.class)
    public JAXBElement<String> createManageFavouritesGuid(String value) {
        return new JAXBElement<String>(_GetICD10DescriptionGuid_QNAME, String.class, ManageFavourites.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "keyList", scope = ManageFavourites.class)
    public JAXBElement<String> createManageFavouritesKeyList(String value) {
        return new JAXBElement<String>(_ManageFavouritesKeyList_QNAME, String.class, ManageFavourites.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "action", scope = ManageFavourites.class)
    public JAXBElement<String> createManageFavouritesAction(String value) {
        return new JAXBElement<String>(_ManageFavouritesAction_QNAME, String.class, ManageFavourites.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfConcept }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetConceptResult", scope = GetConceptResponse.class)
    public JAXBElement<ArrayOfConcept> createGetConceptResponseGetConceptResult(ArrayOfConcept value) {
        return new JAXBElement<ArrayOfConcept>(_GetConceptResponseGetConceptResult_QNAME, ArrayOfConcept.class, GetConceptResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "guid", scope = GetSnoflakeURL.class)
    public JAXBElement<String> createGetSnoflakeURLGuid(String value) {
        return new JAXBElement<String>(_GetICD10DescriptionGuid_QNAME, String.class, GetSnoflakeURL.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "conceptId", scope = GetICD10Children.class)
    public JAXBElement<String> createGetICD10ChildrenConceptId(String value) {
        return new JAXBElement<String>(_GetICD10DescriptionConceptId_QNAME, String.class, GetICD10Children.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "guid", scope = GetICD10Children.class)
    public JAXBElement<String> createGetICD10ChildrenGuid(String value) {
        return new JAXBElement<String>(_GetICD10DescriptionGuid_QNAME, String.class, GetICD10Children.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfMapSet }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetCrossMapSetResult", scope = GetCrossMapSetResponse.class)
    public JAXBElement<ArrayOfMapSet> createGetCrossMapSetResponseGetCrossMapSetResult(ArrayOfMapSet value) {
        return new JAXBElement<ArrayOfMapSet>(_GetCrossMapSetResponseGetCrossMapSetResult_QNAME, ArrayOfMapSet.class, GetCrossMapSetResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "guid", scope = GetRelTypes.class)
    public JAXBElement<String> createGetRelTypesGuid(String value) {
        return new JAXBElement<String>(_GetICD10DescriptionGuid_QNAME, String.class, GetRelTypes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfFavourite }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetFavouritesResult", scope = GetFavouritesResponse.class)
    public JAXBElement<ArrayOfFavourite> createGetFavouritesResponseGetFavouritesResult(ArrayOfFavourite value) {
        return new JAXBElement<ArrayOfFavourite>(_GetFavouritesResponseGetFavouritesResult_QNAME, ArrayOfFavourite.class, GetFavouritesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "name", scope = CreateFavourite.class)
    public JAXBElement<String> createCreateFavouriteName(String value) {
        return new JAXBElement<String>(_RegisterUserName_QNAME, String.class, CreateFavourite.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "guid", scope = CreateFavourite.class)
    public JAXBElement<String> createCreateFavouriteGuid(String value) {
        return new JAXBElement<String>(_GetICD10DescriptionGuid_QNAME, String.class, CreateFavourite.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "guid", scope = GetStatus.class)
    public JAXBElement<String> createGetStatusGuid(String value) {
        return new JAXBElement<String>(_GetICD10DescriptionGuid_QNAME, String.class, GetStatus.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfICD10Children }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetICD10ChildrenResult", scope = GetICD10ChildrenResponse.class)
    public JAXBElement<ArrayOfICD10Children> createGetICD10ChildrenResponseGetICD10ChildrenResult(ArrayOfICD10Children value) {
        return new JAXBElement<ArrayOfICD10Children>(_GetICD10ChildrenResponseGetICD10ChildrenResult_QNAME, ArrayOfICD10Children.class, GetICD10ChildrenResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "guid", scope = GetDescription.class)
    public JAXBElement<String> createGetDescriptionGuid(String value) {
        return new JAXBElement<String>(_GetICD10DescriptionGuid_QNAME, String.class, GetDescription.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "nameSpace", scope = GetConcept.class)
    public JAXBElement<String> createGetConceptNameSpace(String value) {
        return new JAXBElement<String>(_GetConceptNameSpace_QNAME, String.class, GetConcept.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "conceptId", scope = GetConcept.class)
    public JAXBElement<String> createGetConceptConceptId(String value) {
        return new JAXBElement<String>(_GetICD10DescriptionConceptId_QNAME, String.class, GetConcept.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "guid", scope = GetConcept.class)
    public JAXBElement<String> createGetConceptGuid(String value) {
        return new JAXBElement<String>(_GetICD10DescriptionGuid_QNAME, String.class, GetConcept.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "guid", scope = SetConfigValue.class)
    public JAXBElement<String> createSetConfigValueGuid(String value) {
        return new JAXBElement<String>(_GetICD10DescriptionGuid_QNAME, String.class, SetConfigValue.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "key", scope = SetConfigValue.class)
    public JAXBElement<String> createSetConfigValueKey(String value) {
        return new JAXBElement<String>(_SetConfigValueKey_QNAME, String.class, SetConfigValue.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "value", scope = SetConfigValue.class)
    public JAXBElement<String> createSetConfigValueValue(String value) {
        return new JAXBElement<String>(_SetConfigValueValue_QNAME, String.class, SetConfigValue.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfICD10Description }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetICD10DescriptionResult", scope = GetICD10DescriptionResponse.class)
    public JAXBElement<ArrayOfICD10Description> createGetICD10DescriptionResponseGetICD10DescriptionResult(ArrayOfICD10Description value) {
        return new JAXBElement<ArrayOfICD10Description>(_GetICD10DescriptionResponseGetICD10DescriptionResult_QNAME, ArrayOfICD10Description.class, GetICD10DescriptionResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "guid", scope = GetSubSets.class)
    public JAXBElement<String> createGetSubSetsGuid(String value) {
        return new JAXBElement<String>(_GetICD10DescriptionGuid_QNAME, String.class, GetSubSets.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfConcept }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "SearchConceptsResult", scope = SearchConceptsResponse.class)
    public JAXBElement<ArrayOfConcept> createSearchConceptsResponseSearchConceptsResult(ArrayOfConcept value) {
        return new JAXBElement<ArrayOfConcept>(_SearchConceptsResponseSearchConceptsResult_QNAME, ArrayOfConcept.class, SearchConceptsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfRelType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetRelTypesResult", scope = GetRelTypesResponse.class)
    public JAXBElement<ArrayOfRelType> createGetRelTypesResponseGetRelTypesResult(ArrayOfRelType value) {
        return new JAXBElement<ArrayOfRelType>(_GetRelTypesResponseGetRelTypesResult_QNAME, ArrayOfRelType.class, GetRelTypesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfICD10Code }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "SearchICD10CodesResult", scope = SearchICD10CodesResponse.class)
    public JAXBElement<ArrayOfICD10Code> createSearchICD10CodesResponseSearchICD10CodesResult(ArrayOfICD10Code value) {
        return new JAXBElement<ArrayOfICD10Code>(_SearchICD10CodesResponseSearchICD10CodesResult_QNAME, ArrayOfICD10Code.class, SearchICD10CodesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "guid", scope = GetSuffixes.class)
    public JAXBElement<String> createGetSuffixesGuid(String value) {
        return new JAXBElement<String>(_GetICD10DescriptionGuid_QNAME, String.class, GetSuffixes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "guid", scope = SetFavouritePrivateSharedFlag.class)
    public JAXBElement<String> createSetFavouritePrivateSharedFlagGuid(String value) {
        return new JAXBElement<String>(_GetICD10DescriptionGuid_QNAME, String.class, SetFavouritePrivateSharedFlag.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetSnoflakeURLResult", scope = GetSnoflakeURLResponse.class)
    public JAXBElement<String> createGetSnoflakeURLResponseGetSnoflakeURLResult(String value) {
        return new JAXBElement<String>(_GetSnoflakeURLResponseGetSnoflakeURLResult_QNAME, String.class, GetSnoflakeURLResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetStatusResult", scope = GetStatusResponse.class)
    public JAXBElement<ArrayOfStatus> createGetStatusResponseGetStatusResult(ArrayOfStatus value) {
        return new JAXBElement<ArrayOfStatus>(_GetStatusResponseGetStatusResult_QNAME, ArrayOfStatus.class, GetStatusResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "guid", scope = DeleteFavourite.class)
    public JAXBElement<String> createDeleteFavouriteGuid(String value) {
        return new JAXBElement<String>(_GetICD10DescriptionGuid_QNAME, String.class, DeleteFavourite.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "name", scope = RenameFavourite.class)
    public JAXBElement<String> createRenameFavouriteName(String value) {
        return new JAXBElement<String>(_RegisterUserName_QNAME, String.class, RenameFavourite.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "guid", scope = RenameFavourite.class)
    public JAXBElement<String> createRenameFavouriteGuid(String value) {
        return new JAXBElement<String>(_GetICD10DescriptionGuid_QNAME, String.class, RenameFavourite.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "targetCodes", scope = SearchConcepts.class)
    public JAXBElement<String> createSearchConceptsTargetCodes(String value) {
        return new JAXBElement<String>(_SearchConceptsCountTargetCodes_QNAME, String.class, SearchConcepts.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "subsets", scope = SearchConcepts.class)
    public JAXBElement<String> createSearchConceptsSubsets(String value) {
        return new JAXBElement<String>(_SearchConceptsCountSubsets_QNAME, String.class, SearchConcepts.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "guid", scope = SearchConcepts.class)
    public JAXBElement<String> createSearchConceptsGuid(String value) {
        return new JAXBElement<String>(_GetICD10DescriptionGuid_QNAME, String.class, SearchConcepts.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "descendentId", scope = SearchConcepts.class)
    public JAXBElement<String> createSearchConceptsDescendentId(String value) {
        return new JAXBElement<String>(_SearchConceptsCountDescendentId_QNAME, String.class, SearchConcepts.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "saveToFavouriteId", scope = SearchConcepts.class)
    public JAXBElement<String> createSearchConceptsSaveToFavouriteId(String value) {
        return new JAXBElement<String>(_SearchConceptsSaveToFavouriteId_QNAME, String.class, SearchConcepts.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "searchMode", scope = SearchConcepts.class)
    public JAXBElement<String> createSearchConceptsSearchMode(String value) {
        return new JAXBElement<String>(_SearchConceptsSearchMode_QNAME, String.class, SearchConcepts.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "mapSetId", scope = SearchConcepts.class)
    public JAXBElement<String> createSearchConceptsMapSetId(String value) {
        return new JAXBElement<String>(_SearchConceptsCountMapSetId_QNAME, String.class, SearchConcepts.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ancestorId", scope = SearchConcepts.class)
    public JAXBElement<String> createSearchConceptsAncestorId(String value) {
        return new JAXBElement<String>(_SearchConceptsCountAncestorId_QNAME, String.class, SearchConcepts.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "status", scope = SearchConcepts.class)
    public JAXBElement<String> createSearchConceptsStatus(String value) {
        return new JAXBElement<String>(_SearchConceptsCountStatus_QNAME, String.class, SearchConcepts.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "text", scope = SearchConcepts.class)
    public JAXBElement<String> createSearchConceptsText(String value) {
        return new JAXBElement<String>(_SearchConceptsCountText_QNAME, String.class, SearchConcepts.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "suffix", scope = SearchConcepts.class)
    public JAXBElement<String> createSearchConceptsSuffix(String value) {
        return new JAXBElement<String>(_SearchConceptsCountSuffix_QNAME, String.class, SearchConcepts.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "namespaces", scope = SearchConcepts.class)
    public JAXBElement<String> createSearchConceptsNamespaces(String value) {
        return new JAXBElement<String>(_SearchConceptsCountNamespaces_QNAME, String.class, SearchConcepts.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "favorites", scope = SearchConcepts.class)
    public JAXBElement<String> createSearchConceptsFavorites(String value) {
        return new JAXBElement<String>(_SearchConceptsCountFavorites_QNAME, String.class, SearchConcepts.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "guid", scope = GetCrossMapSet.class)
    public JAXBElement<String> createGetCrossMapSetGuid(String value) {
        return new JAXBElement<String>(_GetICD10DescriptionGuid_QNAME, String.class, GetCrossMapSet.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "nameSpace", scope = GetNeighbours.class)
    public JAXBElement<String> createGetNeighboursNameSpace(String value) {
        return new JAXBElement<String>(_GetConceptNameSpace_QNAME, String.class, GetNeighbours.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "guid", scope = GetNeighbours.class)
    public JAXBElement<String> createGetNeighboursGuid(String value) {
        return new JAXBElement<String>(_GetICD10DescriptionGuid_QNAME, String.class, GetNeighbours.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfNeighbourCountResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetNeighbourCountResult", scope = GetNeighbourCountResponse.class)
    public JAXBElement<ArrayOfNeighbourCountResult> createGetNeighbourCountResponseGetNeighbourCountResult(ArrayOfNeighbourCountResult value) {
        return new JAXBElement<ArrayOfNeighbourCountResult>(_GetNeighbourCountResponseGetNeighbourCountResult_QNAME, ArrayOfNeighbourCountResult.class, GetNeighbourCountResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfDescription }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetDescriptionResult", scope = GetDescriptionResponse.class)
    public JAXBElement<ArrayOfDescription> createGetDescriptionResponseGetDescriptionResult(ArrayOfDescription value) {
        return new JAXBElement<ArrayOfDescription>(_GetDescriptionResponseGetDescriptionResult_QNAME, ArrayOfDescription.class, GetDescriptionResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "orgGuid", scope = UnregisterUser.class)
    public JAXBElement<String> createUnregisterUserOrgGuid(String value) {
        return new JAXBElement<String>(_RegisterUserOrgGuid_QNAME, String.class, UnregisterUser.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "userGuid", scope = UnregisterUser.class)
    public JAXBElement<String> createUnregisterUserUserGuid(String value) {
        return new JAXBElement<String>(_RegisterUserUserGuid_QNAME, String.class, UnregisterUser.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "unregisterUserGuid", scope = UnregisterUser.class)
    public JAXBElement<String> createUnregisterUserUnregisterUserGuid(String value) {
        return new JAXBElement<String>(_UnregisterUserUnregisterUserGuid_QNAME, String.class, UnregisterUser.class, value);
    }

}
