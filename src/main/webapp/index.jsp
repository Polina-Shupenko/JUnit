
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<head>
    <title>Lab6</title>
    <style>

        @import url(https://fonts.googleapis.com/css2?family=Raleway:wght@200&display=swap);
        body {
            padding-top: 3rem;
        }

        .container {
            width: 70%;
            margin-top: 6rem;
            margin: auto;
            display: flex;
            justify-content: left;
            align-items: center;
            flex-wrap: wrap;
        }

        h1 {
            margin: auto;
            font-size: 5.5rem;
            letter-spacing: 0.3px;
            text-align: center;
            font-family: 'Raleway', sans-serif;
            color: black;
        }

        .course {
            width: 1280px;
            height: 360px;
            margin: 1rem;
            padding: 0.7rem;
            background: #bde0fe;
            position: relative;
            border-radius: 12px;
            overflow: hidden;
            border: none;
            transition: all 0.4s cubic-bezier(0.175, 0.885, 0, 1);
        }

        .course:hover {
            transform: scale(1.05, 1.05);
        }

        .course *{
            margin: 0;
        }

        .course h4{
            font-size: 3.5rem;
            font-family: 'Raleway', sans-serif;
        }

        .course h3{

            font-family: 'Raleway', sans-serif;
            font-size: 4.95rem;
            margin: 0;
            margin-bottom: 0.3rem;
            -webkit-line-clamp: 1; /* Число отображаемых строк */
            display: -webkit-box; /* Включаем флексбоксы */
            -webkit-box-orient: vertical; /* Вертикальная ориентация */
            overflow: hidden;
        }

        .course.language{
            font-size: 3.95rem;
            font-family: 'Raleway', sans-serif;
        }

        .course.price{
            font-family: 'Raleway', sans-serif;
            font-size: 3.2rem;
            font-weight: 700;
            color: black;
        }

        .course.price::after{
            content: " byn";
        }


    </style>
</head>
<html>
    <body>

    <h1>Наши курсы:</h1>
    <div class="container">

        <c:forEach var="course" items="${courses}">
            <div class="course">
                <h3><c:out value="${course.getName()}" /></h3>
                <h4><c:out value="${course.getTeacher()}" /></h4>
                <p class="language"><c:out value="${course.getLanguage()}" /></p>
                <p class="price"><c:out value="${course.getPrice()}" /></p>
            </div>
        </c:forEach>

    </div>

    <hr/>


    <div class="diagram">
        <canvas id="myChart"></canvas>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script>
        const arr =${names}
        const prices = ${prices}
        const avg = Array(prices.length).fill(${avg})
        const ctx = document.getElementById('myChart');

        new Chart(ctx, {
            data: {
                labels: arr,
                datasets: [{
                    type: 'bar',
                    label: 'Цены',
                    data: prices,
                    backgroundColor: '#ffafcc',
                },{
                    type: 'line',
                    label: 'Средняя цена',
                    data: avg
                    }
                ]
            },

        });
    </script>
    </body>
</html>
