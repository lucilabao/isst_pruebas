# BarrioCovid
Proyecto de ISST

# Configuración BBDD
----------------------
Definicion de rutas y conexiones a las tablas donde se encuentran las credenciales y los roles de los usuarios para autenticacion y autorización.

Configuracion en Servers/Tomcat/server.xml
------------------------------------------
<Realm className="org.apache.catalina.realm.LockOutRealm">
        <Realm className="org.apache.catalina.realm.JDBCRealm" connectionURL="jdbc:h2:~/barrio;USER=sa;PASSWORD=sa;AUTO_SERVER=TRUE" driverName="org.h2.Driver" roleNameCol="rol" userCredCol="password" userNameCol="email" userRoleTable="usuario" userTable="usuario"/>
      </Realm>
