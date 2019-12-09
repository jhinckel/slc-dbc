# slc-dbc <br>
Solução implementada:<br>
    - Criei um FileWatcher para ficar "escutando" as alterações da pasta slc-xml (configurável atraves do arquivo <br>
  application.yml). Assim, quando um novo arquivo é adicionado ele é lido automaticamente pelo sistema. Achei<br>
  melhor essa solução do que colocar uma cron para ficar fazendo polling na pasta dos XMLs, embora essa solução<br>
  não funciona caso a pasta seja remota (NFS, SMB, etc); <br>
    - Utilizei o JAXB para realizar o parser do arquivo XML. Por ter tags com nomes dinâmicos, acabei tendo<br>
  que criar um método para atribuir os valores nos objetos de forma dinâmica usando Reflection (classe XmlUtils).<br>
  Acabou ficando genérico ao ponto de só precisar passar a classe que será instanciada e os nós a serem procesados;<br>
    - Não consegui descobrir até momento como parsear o atributo xmlns do XML. Para os testes acabei tendo que tirar<br>
  ele do XML; <br>
    - Na parte de persistência, utilizei um repositório genérico para abstrair as chamadas do JPA (find, save, etc).<br>
  No lugar, o load, search, update e insert (implementei apenas o load pelo ID e o insert);<br>
    - Utilizei o Swagger para gerar a documentação da API;<br>
    - Para me dedicar a funcionalidade em si do sistema, deixei de fora o tratamento de datas e números (deixei todos<br>
  os campos do XML como string;<br>
    - Criei 2 APIs para retornar os dados inseridos. Uma para retornar o objeto SisMsg e outra para o objeto BcMsg.<br>
  Como não sei como é o relacionamento das duas entidades optei por deixálas separadas. Se necessário podemos criar<br>
  uma nova API para trazer a composição dos dois objetos.<br>
    - Em virtude de eu não ter já um setup pronto antes de iniciar essa atividade, acabou não dando tempo de me <br>
  dedicar aos testes da aplicação. Criei 1 para fins de demonstração de conhecimento que testa o controller da da<br>
  entidade BcMsg (BcmsgControllerTest);<br>
    - Também não consegui ver a aplicação funcionando no Heroku, o processo de build e deploy é executado normalmente<br>
  mas a aplicação não fica acessível. Não consegui descobrir se falta alguma configuração para tal. A URL em questão<br>
  é a https://slc-dbc.herokuapp.com/swagger-ui.html. Porém apresenta erro ao ser chamada. Com mais tempo posso olhar<br>
  os logs utilizando o Heroku CLI.<br>
  
  