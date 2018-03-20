package module;

import javax.sql.DataSource;

import module.domain.ComputerDaoImpl;
import module.domain.ComputerDao;
import module.domain.mapper.ComputerMapper;
import module.domain.mapper.OppMapper;
import module.domain.mapper.ProductMapper;

import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.MyBatisModule;

import play.db.Database;
import play.db.NamedDatabase;
import service.module.UserMapper;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.name.Names;

public class Dependencies extends MyBatisModule {

    protected void initialize() {
        environmentId("development");
        bindConstant().annotatedWith(
                Names.named("mybatis.configuration.failFast")).to(true);
        bindDataSourceProviderType(PlayDataSourceProvider.class);
        bindTransactionFactoryType(JdbcTransactionFactory.class);
        addMapperClass(ComputerMapper.class);
        addMapperClass(OppMapper.class);
        addMapperClass(UserMapper.class);
        addMapperClass(ProductMapper.class);
        bind(ComputerDao.class).to((Class<? extends ComputerDao>) ComputerDaoImpl.class);
    }

    @Singleton
    public static class PlayDataSourceProvider implements Provider<DataSource> {
        final Database db;

        @Inject
        public PlayDataSourceProvider(@NamedDatabase("mydb") final Database db) {
            this.db = db;
        }

        @Override
        public DataSource get() {
            return db.getDataSource();
        }

    }
}
