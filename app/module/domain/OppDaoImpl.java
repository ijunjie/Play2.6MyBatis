package module.domain;

import com.google.inject.Inject;
import module.domain.mapper.OppMapper;

import javax.inject.Singleton;

@Singleton
public class OppDaoImpl implements  OppDao {

    @Inject
    private OppMapper mapper;

    @Override
    public Opportunity getById(String id) {
        return this.mapper.getById(id);
    }
}
