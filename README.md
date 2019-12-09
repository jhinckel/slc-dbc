# slc-dbc <br>
Solução implementada:<br><br>
    <p>- Criei um FileWatcher para ficar "escutando" as alterações da pasta slc-xml (configurável atraves do arquivo
  application.yml). Assim, quando um novo arquivo é adicionado ele é lido automaticamente pelo sistema. Achei
  melhor essa solução do que colocar uma cron para ficar fazendo polling na pasta dos XMLs, embora essa solução
  não funciona caso a pasta seja remota (NFS, SMB, etc); </p>
    <p>- Utilizei o JAXB para realizar o parser do arquivo XML. Por ter tags com nomes dinâmicos, acabei tendo
  que criar um método para atribuir os valores nos objetos de forma dinâmica usando Reflection (classe XmlUtils).
  Acabou ficando genérico ao ponto de só precisar passar a classe que será instanciada e os nós a serem procesados;</p>
    <p>- Não consegui descobrir até momento como parsear o atributo xmlns do XML. Para os testes acabei tendo que tirar
  ele do XML; </p>
    <p>- Na parte de persistência, utilizei um repositório genérico para abstrair as chamadas do JPA (find, save, etc).
  No lugar, o load, search, update e insert (implementei apenas o load pelo ID e o insert);</p>
    <p>- Utilizei o Swagger para gerar a documentação da API;</p>
    <p>- Para me dedicar a funcionalidade em si do sistema, deixei de fora o tratamento de datas e números (deixei todos
  os campos do XML como string;</p>
    <p>- Criei 2 APIs para retornar os dados inseridos. Uma para retornar o objeto SisMsg e outra para o objeto BcMsg.
  Como não sei como é o relacionamento das duas entidades optei por deixálas separadas. Se necessário podemos criar
  uma nova API para trazer a composição dos dois objetos.</p>
    <p>- Em virtude de eu não ter já um setup pronto antes de iniciar essa atividade, acabou não dando tempo de me 
  dedicar aos testes da aplicação. Criei 1 para fins de demonstração de conhecimento que testa o controller da da
  entidade BcMsg (BcmsgControllerTest);</p>
    <p>- Também não consegui ver a aplicação funcionando no Heroku. O processo de build e deploy é executado normalmente
  mas a aplicação não fica acessível. Não consegui descobrir se falta alguma configuração para tal. A URL em questão
  é a https://slc-dbc.herokuapp.com/swagger-ui.html. Porém apresenta erro ao ser chamada. Com mais tempo posso olhar
  os logs utilizando o Heroku CLI.</p>
  
  