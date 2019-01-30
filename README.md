### run mongo in docker
```
docker run --name docker-mongo -v /Users/admin/Documents/docker/mongo/data:/data/db -p 27017:27017 -d mongo
```

### install adminMongo
> use cmd , input [cd] into your local directory where you want to install adminMongo
```
git clone https://github.com/mrvautin/adminMongo
```
```
cd adminMongo
npm install
npm start
```

> access to http://localhost:1234/app/connection_list

> set connect information as [mongodb://{ip}:27017]
> for example: [mongodb://192.168.3.52:27017]

### run demo as spring boot project
> access to the swagger ui page
http://localhost:8071/demo/swagger-ui.html#


### mongo db
<table>
    <tr>
        <td>SQL术语/概念</td>
        <td>MongoDB术语/概念</td>
        <td>解释/说明</td>
    </tr>
    <tr>
        <td>database</td>
        <td>database</td>
        <td>数据库</td>
    </tr>
    <tr>
        <td>table</td>
        <td>collection</td>
        <td>数据库表/集合</td>
    </tr>
    <tr>
        <td>row</td>
        <td>document</td>
        <td>数据记录行/文档</td>
    </tr>
    <tr>
        <td>column</td>
        <td>field</td>
        <td>数据字段/域</td>
    </tr>
    <tr>
        <td>index</td>
        <td>index</td>
        <td>索引</td>
    </tr>
    <tr>
        <td>table joins</td>
        <td> </td>
        <td>表连接,MongoDB不支持</td>
    </tr>
    <tr>
        <td>primary key</td>
        <td>primary key</td>
        <td>主键,MongoDB自动将_id字段设置为主键</td>
    </tr>
</table>
