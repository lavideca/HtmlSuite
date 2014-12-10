package labo1.alfonso.business;

public abstract class ServiceBase<TRepository, TEntity> {
	protected TRepository getRepository() {
		return repository;
	}

	protected void setRepository(TRepository repository) {
		this.repository = repository;
	}

	private TRepository repository;
}
