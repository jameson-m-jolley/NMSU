
#this is for starting the NMSU docker contanter
sudo systemctl start docker
sudo docker run --name NMSU-DBMS -p 3306:3306  -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql:latest
sudo docker start NMSU-DBMS
