/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.component.xmlsecurity.springboot;

import java.util.Map;
import javax.annotation.Generated;
import javax.xml.crypto.KeySelector;
import javax.xml.crypto.URIDereferencer;
import org.apache.camel.component.xmlsecurity.api.ValidationFailedHandler;
import org.apache.camel.component.xmlsecurity.api.XmlSignature2Message;
import org.apache.camel.component.xmlsecurity.api.XmlSignatureChecker;
import org.apache.camel.spring.boot.ComponentConfigurationPropertiesCommon;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Used to verify exchanges using the XML signature specification.
 * 
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
@Generated("org.apache.camel.springboot.maven.SpringBootAutoConfigurationMojo")
@ConfigurationProperties(prefix = "camel.component.xmlsecurity-verify")
public class XmlVerifierComponentConfiguration
        extends
            ComponentConfigurationPropertiesCommon {

    /**
     * Whether to enable auto configuration of the xmlsecurity-verify component.
     * This is enabled by default.
     */
    private Boolean enabled;
    /**
     * Whether the producer should be started lazy (on the first message). By
     * starting lazy you can use this to allow CamelContext and routes to
     * startup in situations where a producer may otherwise fail during starting
     * and cause the route to fail being started. By deferring this startup to
     * be lazy then the startup failure can be handled during routing messages
     * via Camel's routing error handlers. Beware that when the first message is
     * processed then creating and starting the producer may take a little time
     * and prolong the total processing time of the processing.
     */
    private Boolean lazyStartProducer = false;
    /**
     * Whether the component should use basic property binding (Camel 2.x) or
     * the newer property binding with additional capabilities
     */
    private Boolean basicPropertyBinding = false;
    /**
     * To use a shared XmlVerifierConfiguration configuration to use as base for
     * configuring endpoints.
     */
    private XmlVerifierConfigurationNestedConfiguration verifierConfiguration;

    public Boolean getLazyStartProducer() {
        return lazyStartProducer;
    }

    public void setLazyStartProducer(Boolean lazyStartProducer) {
        this.lazyStartProducer = lazyStartProducer;
    }

    public Boolean getBasicPropertyBinding() {
        return basicPropertyBinding;
    }

    public void setBasicPropertyBinding(Boolean basicPropertyBinding) {
        this.basicPropertyBinding = basicPropertyBinding;
    }

    public XmlVerifierConfigurationNestedConfiguration getVerifierConfiguration() {
        return verifierConfiguration;
    }

    public void setVerifierConfiguration(
            XmlVerifierConfigurationNestedConfiguration verifierConfiguration) {
        this.verifierConfiguration = verifierConfiguration;
    }

    public static class XmlVerifierConfigurationNestedConfiguration {
        public static final Class CAMEL_NESTED_CLASS = org.apache.camel.component.xmlsecurity.processor.XmlVerifierConfiguration.class;
        /**
         * Provides the key for validating the XML signature.
         */
        private KeySelector keySelector;
        /**
         * Sets the output node search value for determining the node from the
         * XML signature document which shall be set to the output message body.
         * The class of the value depends on the type of the output node search.
         * The output node search is forwarded to XmlSignature2Message.
         */
        private Object outputNodeSearch;
        /**
         * Determines the search type for determining the output node which is
         * serialized into the output message bodyF. See
         * setOutputNodeSearch(Object). The supported default search types you
         * can find in DefaultXmlSignature2Message.
         */
        private String outputNodeSearchType = "Default";
        /**
         * Indicator whether the XML signature elements (elements with local
         * name Signature and namesapce http://www.w3.org/2000/09/xmldsig#)
         * shall be removed from the document set to the output message.
         * Normally, this is only necessary, if the XML signature is enveloped.
         * The default value is Boolean#FALSE. This parameter is forwarded to
         * XmlSignature2Message. This indicator has no effect if the output node
         * search is of type
         * DefaultXmlSignature2Message#OUTPUT_NODE_SEARCH_TYPE_DEFAULT.F
         */
        private Boolean removeSignatureElements = false;
        /**
         * Enables secure validation. If true then secure validation is enabled.
         */
        private Boolean secureValidation = true;
        /**
         * Handles the different validation failed situations. The default
         * implementation throws specific exceptions for the different
         * situations (All exceptions have the package name
         * org.apache.camel.component.xmlsecurity.api and are a sub-class of
         * XmlSignatureInvalidException. If the signature value validation
         * fails, a XmlSignatureInvalidValueException is thrown. If a reference
         * validation fails, a XmlSignatureInvalidContentHashException is
         * thrown. For more detailed information, see the JavaDoc.
         */
        private ValidationFailedHandler validationFailedHandler;
        /**
         * Bean which maps the XML signature to the output-message after the
         * validation. How this mapping should be done can be configured by the
         * options outputNodeSearchType, outputNodeSearch, and
         * removeSignatureElements. The default implementation offers three
         * possibilities which are related to the three output node search types
         * Default, ElementName, and XPath. The default implementation
         * determines a node which is then serialized and set to the body of the
         * output message If the search type is ElementName then the output node
         * (which must be in this case an element) is determined by the local
         * name and namespace defined in the search value (see option
         * outputNodeSearch). If the search type is XPath then the output node
         * is determined by the XPath specified in the search value (in this
         * case the output node can be of type Element, TextNode or Document).
         * If the output node search type is Default then the following rules
         * apply: In the enveloped XML signature case (there is a reference with
         * URI= and transform
         * http://www.w3.org/2000/09/xmldsig#enveloped-signature), the incoming
         * XML document without the Signature element is set to the output
         * message body. In the non-enveloped XML signature case, the message
         * body is determined from a referenced Object; this is explained in
         * more detail in chapter Output Node Determination in Enveloping XML
         * Signature Case.
         */
        private XmlSignature2Message xmlSignature2Message;
        /**
         * This interface allows the application to check the XML signature
         * before the validation is executed. This step is recommended in
         * http://www.w3.org/TR/xmldsig-bestpractices/#check-what-is-signed
         */
        private XmlSignatureChecker xmlSignatureChecker;
        /**
         * You can set a base URI which is used in the URI dereferencing.
         * Relative URIs are then concatenated with the base URI.
         */
        private String baseUri;
        /**
         * Determines if the XML signature specific headers be cleared after
         * signing and verification. Defaults to true.
         */
        private Boolean clearHeaders = true;
        /**
         * Sets the crypto context properties. See {link
         * XMLCryptoContext#setProperty(String, Object)}. Possible properties
         * are defined in XMLSignContext an XMLValidateContext (see Supported
         * Properties). The following properties are set by default to the value
         * Boolean#TRUE for the XML validation. If you want to switch these
         * features off you must set the property value to Boolean#FALSE.
         * org.jcp.xml.dsig.validateManifests
         * javax.xml.crypto.dsig.cacheReference
         */
        private Map cryptoContextProperties;
        /**
         * Disallows that the incoming XML document contains DTD DOCTYPE
         * declaration. The default value is Boolean#TRUE.
         */
        private Boolean disallowDoctypeDecl = true;
        /**
         * Indicator whether the XML declaration in the outgoing message body
         * should be omitted. Default value is false. Can be overwritten by the
         * header XmlSignatureConstants#HEADER_OMIT_XML_DECLARATION.
         */
        private Boolean omitXmlDeclaration = false;
        /**
         * The character encoding of the resulting signed XML document. If null
         * then the encoding of the original XML document is used.
         */
        private String outputXmlEncoding;
        /**
         * Classpath to the XML Schema. Must be specified in the detached XML
         * Signature case for determining the ID attributes, might be set in the
         * enveloped and enveloping case. If set, then the XML document is
         * validated with the specified XML schema. The schema resource URI can
         * be overwritten by the header
         * XmlSignatureConstants#HEADER_SCHEMA_RESOURCE_URI.
         */
        private String schemaResourceUri;
        /**
         * If you want to restrict the remote access via reference URIs, you can
         * set an own dereferencer. Optional parameter. If not set the provider
         * default dereferencer is used which can resolve URI fragments, HTTP,
         * file and XPpointer URIs. Attention: The implementation is provider
         * dependent!
         */
        private URIDereferencer uriDereferencer;

        public KeySelector getKeySelector() {
            return keySelector;
        }

        public void setKeySelector(KeySelector keySelector) {
            this.keySelector = keySelector;
        }

        public Object getOutputNodeSearch() {
            return outputNodeSearch;
        }

        public void setOutputNodeSearch(Object outputNodeSearch) {
            this.outputNodeSearch = outputNodeSearch;
        }

        public String getOutputNodeSearchType() {
            return outputNodeSearchType;
        }

        public void setOutputNodeSearchType(String outputNodeSearchType) {
            this.outputNodeSearchType = outputNodeSearchType;
        }

        public Boolean getRemoveSignatureElements() {
            return removeSignatureElements;
        }

        public void setRemoveSignatureElements(Boolean removeSignatureElements) {
            this.removeSignatureElements = removeSignatureElements;
        }

        public Boolean getSecureValidation() {
            return secureValidation;
        }

        public void setSecureValidation(Boolean secureValidation) {
            this.secureValidation = secureValidation;
        }

        public ValidationFailedHandler getValidationFailedHandler() {
            return validationFailedHandler;
        }

        public void setValidationFailedHandler(
                ValidationFailedHandler validationFailedHandler) {
            this.validationFailedHandler = validationFailedHandler;
        }

        public XmlSignature2Message getXmlSignature2Message() {
            return xmlSignature2Message;
        }

        public void setXmlSignature2Message(
                XmlSignature2Message xmlSignature2Message) {
            this.xmlSignature2Message = xmlSignature2Message;
        }

        public XmlSignatureChecker getXmlSignatureChecker() {
            return xmlSignatureChecker;
        }

        public void setXmlSignatureChecker(
                XmlSignatureChecker xmlSignatureChecker) {
            this.xmlSignatureChecker = xmlSignatureChecker;
        }

        public String getBaseUri() {
            return baseUri;
        }

        public void setBaseUri(String baseUri) {
            this.baseUri = baseUri;
        }

        public Boolean getClearHeaders() {
            return clearHeaders;
        }

        public void setClearHeaders(Boolean clearHeaders) {
            this.clearHeaders = clearHeaders;
        }

        public Map getCryptoContextProperties() {
            return cryptoContextProperties;
        }

        public void setCryptoContextProperties(Map cryptoContextProperties) {
            this.cryptoContextProperties = cryptoContextProperties;
        }

        public Boolean getDisallowDoctypeDecl() {
            return disallowDoctypeDecl;
        }

        public void setDisallowDoctypeDecl(Boolean disallowDoctypeDecl) {
            this.disallowDoctypeDecl = disallowDoctypeDecl;
        }

        public Boolean getOmitXmlDeclaration() {
            return omitXmlDeclaration;
        }

        public void setOmitXmlDeclaration(Boolean omitXmlDeclaration) {
            this.omitXmlDeclaration = omitXmlDeclaration;
        }

        public String getOutputXmlEncoding() {
            return outputXmlEncoding;
        }

        public void setOutputXmlEncoding(String outputXmlEncoding) {
            this.outputXmlEncoding = outputXmlEncoding;
        }

        public String getSchemaResourceUri() {
            return schemaResourceUri;
        }

        public void setSchemaResourceUri(String schemaResourceUri) {
            this.schemaResourceUri = schemaResourceUri;
        }

        public URIDereferencer getUriDereferencer() {
            return uriDereferencer;
        }

        public void setUriDereferencer(URIDereferencer uriDereferencer) {
            this.uriDereferencer = uriDereferencer;
        }
    }
}