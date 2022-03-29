package br.com.lpr.write.persistence;

import org.springframework.stereotype.Repository;

import br.com.lpr.entities.User;
import br.com.lpr.write.persistence.main.IWriteMainPersistence;

@Repository
public interface IUseWritePersistence extends IWriteMainPersistence<User, Integer> {
	
}
