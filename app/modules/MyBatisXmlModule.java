package modules;


import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.util.Properties;

/**
 * Mybatis XML-Config.
 *
 * <p>
 *
 * @author Howe Xiong
 */

public class MyBatisXmlModule  extends  org.mybatis.guice.XMLMyBatisModule{
    @Override
    protected void initialize() {
        Config config = ConfigFactory.load();
        Properties props = new Properties();
        props.setProperty("driver", config.getString("db.mydb.driver"));
        props.setProperty("url", config.getString("db.mydb.url"));
        props.setProperty("username", config.getString("db.mydb.user"));
        props.setProperty("password", config.getString("db.mydb.password"));
        setEnvironmentId("default");

        addProperties(props);
    }
}
