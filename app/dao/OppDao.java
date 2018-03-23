package dao;

import entities.Opportunity;

public interface OppDao {
    Opportunity getById(final String id);
}
