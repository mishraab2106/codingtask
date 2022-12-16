
docker build -t e-newspaper.jar .

docker run -d -v C:\Users\Mishr\Desktop\eclipse_projects\codingtask\codingtask\db:/etc/db -p 8080:8080 e-newspaper.jar

docker run  -v C:\Users\Mishr\Desktop\eclipse_projects\codingtask\codingtask\db:/etc/db -p 8080:8080 e-newspaper.jar


Please find the below Rest APIs which could be used by the GUI team for sorting,filtering and pagination purposes

Fetch all papers
http://localhost:8080/allpapers

Add papers
http://localhost:8080/addpapers

Delete by Id
http://localhost:8080/deletepapers?id=1






Filters & Sorting
//To sort by the column name
http://localhost:8080/filtersortpapers?sort_by=filename

//To filter by the uploadtime & also sort by dpi + pagination

http://localhost:8080/filtersortpapers?uploadtime=20
http://localhost:8080/filtersortpapers?uploadtime=1&sort_by=dpi&offset=0&pagesize=10

//To filter by the width & also sort by dpi + pagination

http://localhost:8080/filtersortpapers?width=2
http://localhost:8080/filtersortpapers?width=2&sort_by=dpi&offset=0&pagesize=10

//To filter by the height & also sort by dpi + pagination

http://localhost:8080/filtersortpapers?height=1
http://localhost:8080/filtersortpapers?height=1&sort_by=dpi&offset=0&pagesize=10

//To filter by the dpi & also sort by newspapername + pagination

http://localhost:8080/filtersortpapers?dpi=2
http://localhost:8080/filtersortpapers?dpi=2&sort_by=newspapername&offset=0&pagesize=10

//To filter by the newspapername & also sort by dpi + pagination

http://localhost:8080/filtersortpapers?newspapername=abb
http://localhost:8080/filtersortpapers?newspapername=abb&sort_by=dpi&offset=0&pagesize=10

//To filter by the filename & also sort by newspapername + pagination

http://localhost:8080/filtersortpapers?filename=xml
http://localhost:8080/filtersortpapers?filename=xml&sort_by=newspapername&offset=0&pagesize=10