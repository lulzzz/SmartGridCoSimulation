//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.09.07 at 04:15:46 PM CEST 
//


package opcMEMAP.serverConfigurationClassesXML;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the serverConfigurationClasses package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: serverConfigurationClasses
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ServerConfig }
     * 
     */
    public ServerConfig createServerconfig() {
        return new ServerConfig();
    }

    /**
     * Create an instance of {@link ServerConfig.Nodes }
     * 
     */
    public ServerConfig.Nodes createServerconfigNodes() {
        return new ServerConfig.Nodes();
    }

    /**
     * Create an instance of {@link ServerConfig.Nodes.Node }
     * 
     */
    public ServerConfig.Nodes.Node createServerconfigNodesNode() {
        return new ServerConfig.Nodes.Node();
    }

    /**
     * Create an instance of {@link ServerConfig.FolderNodes }
     * 
     */
    public ServerConfig.FolderNodes createServerconfigFolderNodes() {
        return new ServerConfig.FolderNodes();
    }

    /**
     * Create an instance of {@link ServerConfig.NameSpaces }
     * 
     */
    public ServerConfig.NameSpaces createServerconfigNameSpaces() {
        return new ServerConfig.NameSpaces();
    }

    /**
     * Create an instance of {@link ServerConfig.Nodes.Node.ModbusConnector }
     * 
     */
    public ServerConfig.Nodes.Node.ModbusConnector createServerconfigNodesNodeModbusConnector() {
        return new ServerConfig.Nodes.Node.ModbusConnector();
    }

    /**
     * Create an instance of {@link ServerConfig.Nodes.Node.MqttConnector }
     * 
     */
    public ServerConfig.Nodes.Node.MqttConnector createServerconfigNodesNodeMqttConnector() {
        return new ServerConfig.Nodes.Node.MqttConnector();
    }

    /**
     * Create an instance of {@link ServerConfig.FolderNodes.FolderNode }
     * 
     */
    public ServerConfig.FolderNodes.FolderNode createServerconfigFolderNodesFolderNode() {
        return new ServerConfig.FolderNodes.FolderNode();
    }

}
