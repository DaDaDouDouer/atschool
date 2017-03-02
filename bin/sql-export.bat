set sql_file_path=M:\reusebook_repo\sql\reusebook.sql
del /q %sql_file_path%
mysqldump --opt -h localhost -u root -p graduate_design>%sql_file_path%
pause