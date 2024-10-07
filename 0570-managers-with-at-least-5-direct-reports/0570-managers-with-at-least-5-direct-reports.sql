SELECT Manager.name
FROM Employee
INNER JOIN Employee as Manager
    ON (Employee.managerID = Manager.id)
GROUP BY Manager.id
HAVING count(*) >= 5;