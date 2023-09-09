package ir.mapsa.librarymanagement.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IBaseRepository<E extends BaseEntity, ID> extends JpaRepository<E, ID> {
}
