package snippet;

public class Snippet {
	 @Transactional("readPlatformTransactionManager")
	    @DisplayName("findAll. Listar todos os usuarios, quando for sucesso")
		public List<User> findAll_ReturnAllUser_WhenSuccess() {
			 return userReadRepository.findAll();
		 }
}

