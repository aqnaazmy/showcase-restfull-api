# API SPEC SHOWCASE APP

## Register User
Request :
- Method : `POST`
- Endpoint : `api/register`
- Header :
    - Content-Type: application/json
    - Accept: application/json
- Body :
```json
{
  "email" : "string",
  "password" : "string",
  "name" : "string"
}
```
Response :
```json
{
  "code" : "number",
  "status" : "string",
  "data" : {
    "id" : "id user, uniq",
    "name" : "string",
    "token" : "string",
    "created_at" : "date",
    "update_at" : "date"
  }
}
```

## Login User
Request :
- Method : `POST`
- Endpoint : `api/login`
- Header :
    - Content-Type: application/json
    - Accept: application/json
- Body :
```json
{
  "email" : "string",
  "password" : "string"
}
```
Response :
```json
{
  "code" : "number",
  "status" : "string",
  "data" : {
    "id" : "id user, uniq",
    "name" : "string",
    "token" : "string",
    "created_at" : "date",
    "update_at" : "date"
  }
}
```

>NOTE : To access this endpoint use the Authorization
## Create Showcase
Request : 
- Method : `POST`
- Endpoint : `api/showcase`
- Header :
  - Content-Type: application/json
  - Accept: application/json
  - Authorization: Bearer {{token}}
- Body :
```json
{
  "id" : "id product, uniq",
  "title" : "string",
  "image" : "string",
  "description" : "string",
  "category_id" : "string"
}
```
Response :
```json
{
  "code" : "number",
  "status" : "string",
  "data" : {
    "id" : "id product, uniq",
    "title" : "string",
    "image" : "string",
    "description" : "string",
    "category_id" : "string",
    "created_at" : "date",
    "update_at" : "date"
  }
}
```
## Get Showcase By User
Request :
- Method : `GET`
- Endpoint : `api/showcase/{id_showcase}`
- Header :
    - Accept: application/json
    - Authorization: Bearer {{token}} 

Response :
```json
{
  "code" : "number",
  "status" : "string",
  "data" : {
    "id" : "id product, uniq",
    "title" : "string",
    "image" : "string",
    "description" : "string",
    "category_id" : "string",
    "created_at" : "date",
    "update_at" : "date"
  }
}
```
## Update Showcase By User
Request :
- Method : `PUT`
- Endpoint : `api/showcase/{id_showcase}`
- Header :
    - Content-Type: application/json
    - Accept: application/json
    - Authorization: Bearer {{token}}
- Body :
```json
{
  "title" : "string",
  "image" : "string",
  "description" : "string",
  "category_id" : "string"
}
```
Response :
```json
{
  "code" : "number",
  "status" : "string",
  "data" : {
    "id" : "id product, uniq",
    "title" : "string",
    "image" : "string",
    "description" : "string",
    "category_id" : "string",
    "created_at" : "date",
    "update_at" : "date"
  }
}
```
## List Showcase By User
Request :
- Method : `GET`
- Endpoint : `api/showcase`
- Header :
    - Authorization: Bearer {{token}}
    - Accept: application/json 
- Query Param :
  - size : number
  - page : number
  
Response :
```json
{
  "code" : "number",
  "status" : "string",
  "data" : [
    {
      "id" : "id product, uniq",
      "title" : "string",
      "image" : "string",
      "description" : "string",
      "category_id" : "string",
      "created_at" : "date",
      "update_at" : "date"
    },
    {
      "id" : "id product, uniq",
      "title" : "string",
      "image" : "string",
      "description" : "string",
      "category_id" : "string",
      "created_at" : "date",
      "update_at" : "date"
    }
  ]
}
```

## Delete Showcase 
Request :
- Method : `DELETE`
- Endpoint : `api/showcase/{id_showcase}`
- Header :
    - Authorization: Bearer {{token}}
    - Accept: application/json

Response :
```json
{
  "code" : "number",
  "status" : "string"
}
```

>NOTE : To access this endpoint not use the Authorization
## List Showcase
Request :
- Method : `GET`
- Endpoint : `api/showcase`
- Header :
    - Accept: application/json
- Query Param :
    - size : number
    - page : number

Response :
```json
{
  "code" : "number",
  "status" : "string",
  "data" : [
    {
      "id" : "id product, uniq",
      "title" : "string",
      "image" : "string",
      "description" : "string",
      "category_id" : "string",
      "created_at" : "date",
      "update_at" : "date"
    },
    {
      "id" : "id product, uniq",
      "title" : "string",
      "image" : "string",
      "description" : "string",
      "category_id" : "string",
      "created_at" : "date",
      "update_at" : "date"
    }
  ]
}
```

## Get Showcase
Request :
- Method : `GET`
- Endpoint : `api/showcase/{id_showcase}`
- Header :
    - Accept: application/json

Response :
```json
{
  "code" : "number",
  "status" : "string",
  "data" : {
    "id" : "id product, uniq",
    "title" : "string",
    "image" : "string",
    "description" : "string",
    "category_id" : "string",
    "created_at" : "date",
    "update_at" : "date"
  }
}
```