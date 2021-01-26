# SpringOAuth2 SSO JWT 多登陆方式
## 使用方法
* 导入logindemo.sql到数据库
* 启动auth、clientA、clientB服务
* 访问http://localhost:8082/userInfo或http://localhost:8083/userInfo
* 若未认证会跳转到auth服务进行认证，认证结束后自动跳转回认证前url
* 在auth服务通过认证后，clientA、clientB都可以访问
* 访问http://localhost:8082/adminInfo会报403无权访问错误
 
