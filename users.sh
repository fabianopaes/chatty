curl -X POST "http://localhost:8080/users" -H "accept: application/json" -H "Content-Type: application/json" -d "{\"name\":\"Fabiano Paes\",\"username\":\"fabiano.paes\"}"
echo ""
curl -X POST "http://localhost:8080/users" -H "accept: application/json" -H "Content-Type: application/json" -d "{\"name\":\"Peter Gibbons\",\"username\":\"peter.gibbons\"}"

echo ""
curl -X POST "http://localhost:8080/users" -H "accept: application/json" -H "Content-Type: application/json" -d "{\"name\":\"Fabiano Paes\",\"username\":\"FABIANO2.paes\"}"
echo ""
curl -X POST "http://localhost:8080/users" -H "accept: application/json" -H "Content-Type: application/json" -d "{\"name\":\"Peter Gibbons\",\"username\":\"PETER2.gibbons\"}"


echo ""
curl -X POST "http://localhost:8080/users" -H "accept: application/json" -H "Content-Type: application/json" -d "{\"name\":\"Fabiano Paes\",\"username\":\"fabiano2.paes\"}"
echo ""
curl -X POST "http://localhost:8080/users" -H "accept: application/json" -H "Content-Type: application/json" -d "{\"name\":\"Peter Gibbons\",\"username\":\"peter2.gibbons\"}"



echo ""
curl -X POST "http://localhost:8080/users" -H "accept: application/json" -H "Content-Type: application/json" -d "{\"name\":\"Fabiano Paes\",\"username\":\"FABIANO.PAES\"}"
echo ""
curl -X POST "http://localhost:8080/users" -H "accept: application/json" -H "Content-Type: application/json" -d "{\"name\":\"Peter Gibbons\",\"username\":\"PETER.gibbons\"}"