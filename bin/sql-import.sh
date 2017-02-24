# 导出数据库
databaseName="graduate_design"
sqlPath="./sql/reusebook.sql"

mysql -u root -p << EOF
drop database ${databaseName};
create database ${databaseName};
use ${databaseName};
source ${sqlPath};
EOF
