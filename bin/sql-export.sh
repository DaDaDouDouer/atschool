# 导出数据库
databaseName="graduate_design"
sqlPath="./sql/reusebook.sql"

rm -rf ${sqlPath};
mysqldump -u root -p 123456 ${databaseName} > ${sqlPath};
