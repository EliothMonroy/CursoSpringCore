#!/bin/bash
#url de conexion: 
url="jdbc:h2:data/curso-spring"
#Driver:
driver="org.h2.Driver"

echo "iniciando h2"
echo "url: $url"
echo "driver: $driver"

java -cp h2-1.3.170.jar org.h2.tools.Server
