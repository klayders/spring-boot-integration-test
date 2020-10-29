# This example service with hot news and comments

- Added docker-compose
- Added integration test 
- Work with **apache kafka**, **elasticsearch**, **redis**, **postgresql**;


## REST API 
### add comment
```
curl --location --request POST 'http://localhost:8080/api/v2/comment/add' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id": 1,
    "authorId": 5,
    "newsId": 2,
    "message": "wtf"
}'
``` 
### add hot news
```
curl --location --request POST 'http://localhost:8080/api/v2/news/hot/add' \
--header 'Content-Type: application/json' \
--header 'Cookie: Cookie_2=value; ga_local=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJycyI6IjNmZmFmZmZmZmVmODAiLCJsb2MiOiJydSIsImZsZ3MiOiJ7XCJ2cHBcIjp0cnVlLFwidmlwQ29sbGVjdGlvblwiOlwiXCIsXCJ2aXBJdGVtc09yZGVyXCI6XCJudWxsXCIsXCJoaWRlR2FtZVByb21wdFwiOnRydWV9IiwicnYiOiJTSVRFIiwidmR0Ijoie1wibFwiOjQsXCJhbFwiOjF9IiwiZm4iOiLQodC10YDQs9C10LkiLCJkbiI6ImdyZXlsb2siLCJvaWQiOjMxNTQsInZpZCI6IjIyMjE0MTkyMCIsInNlZyI6NCwiZXhwIjoxNTk3MzI5NTIzLCJ2aXAiOnRydWUsImFwbCI6MzAwLCJtbCI6InNlcmdleS5hbmlzaW1vdkBzdG9sb3RvLnJ1Iiwic3QiOiJSRUdJU1RFUkVEIiwib3IiOiJHT1NMT1RPIiwiYyI6IlJVIiwiYXB0IjoiWUVTIiwiZiI6dHJ1ZSwiaXAiOiIyMTcuMTA3LjEyNC45NCIsImkiOjE4MTYwMDg4LCJmcHQiOiJXQUxMRVQsQk9OVVMsU0JFUkJBTks6Q0FSRCxQQVkzNjUsQ0hST05PUEFZOkNBUkQiLCJsIjoiZ3JleWxvayIsIm0iOiI3OTI1ODczMTUxMCIsInZkIjpmYWxzZSwibyI6dHJ1ZSwicmQiOjEyNjMyMTA4NTcwMDAsInciOjEyNTA5MDkxMjk3MCwic2NwbyI6dHJ1ZSwiZmJ5IjoyMDE4fQ.qyXbE2xblzfwtjsQx_pUFBdtsCLQULF3CtU0AtOlLps' \
--data-raw '{
    "title": "HOOOTT NEWS!!!!!",
    "description": "read this NEWS!!!!!"
}'
```


### find news with comments
