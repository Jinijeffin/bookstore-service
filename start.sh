#!/bin/bash
echo "Starting PostgreSQL..."
sudo service postgresql start
sudo sed -i 's/local   all             postgres                                peer/local   all             postgres                                trust/' /etc/postgresql/16/main/pg_hba.conf
sudo service postgresql restart
sudo runuser -l postgres -c "psql -c \"CREATE USER bookuser WITH PASSWORD 'book123';\"" 2>/dev/null
sudo runuser -l postgres -c "psql -c \"CREATE DATABASE bookstoredb OWNER bookuser;\"" 2>/dev/null
echo "Starting Spring Boot..."
cd /workspaces/bookstore-service/bookstore
./gradlew bootRun
