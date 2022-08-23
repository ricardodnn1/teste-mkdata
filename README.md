# TESTE MKDATA
Teste para programador Java Sprint Boot + PostgreSQL - Empresa MKDATA


Aplicação desenvolvida com Java Spring Boot 2.7 Stable.



# Instruções para rodar em localhost.
1. Configure os dados de acesso ao banco de dados PostgreSQL no arquivo application.properties, localizado na pasta resources. 
2. Execute o projeto utilizando o arquivo CrudApplication.java

O banco de dados é gerado no momento da execução do projeto! 
Não há necessidade de importação do SQL para criação da base de dados. 

# Heroku 

1. Listar todos clientes: https://mkdata-customers-api.herokuapp.com/api/customers/list | HTTP GET
2. Cadastrar clientes: https://mkdata-customers-api.herokuapp.com/api/customers/save | HTTP POST
   1. Json Body: 
   2. {
        "cpfCnpj": "347.685.818-97",
        "name": "Ricardo D. Nunes",
        "rgIe": "40.645.222-2",
        "status": "1",
        "typePerson": "F",
        "contacts": [
            {
                "phone": "(11) 98630-0442"
            },
            {
                "phone": "(11) 91260-9840"
            }
        ]
    }
 3. Atualizar cliente: https://mkdata-customers-api.herokuapp.com/api/customers/update | HTTP PUT
     1. Json Body: 
     2. {
        "id": 1, 
        "cpfCnpj": "347.685.818-97",
        "name": "Ricardo D. Nunes",
        "rgIe": "40.645.222-2",
        "status": "1",
        "typePerson": "F",
        "contacts": [
            {
                "phone": "(11) 98630-0442"
            },
            {
                "phone": "(11) 91260-9840"
            }
        ]
    }
   4. Remover cliente: https://mkdata-customers-api.herokuapp.com/api/customers/delete/1 | HTTP DELETE
