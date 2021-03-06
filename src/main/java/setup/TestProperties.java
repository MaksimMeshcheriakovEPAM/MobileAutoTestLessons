package setup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Properties using
 */
class TestProperties {
    String currentPropertyFile;
    Properties currentProps = new Properties();

    protected void setPropertyFile(PropertyFile propertyFile){
        currentPropertyFile = propertyFile.getName();
    }

    /**
     * Read set of properties
     * @return
     * @throws IOException
     */
    Properties getCurrentProps() throws IOException {
        FileInputStream in = new FileInputStream(currentPropertyFile);
        currentProps.load(in);
        in.close();
        return currentProps;
    }

    /**
     * Return certain property value by key
     * @param propKey
     * @return
     * @throws IOException
     */
    protected String getProp(String propKey) throws IOException {
        if(!currentProps.containsKey(propKey)) currentProps = getCurrentProps();
        // "default" form used to handle the absence of parameter
        return currentProps.getProperty(propKey, null);

    }


}
