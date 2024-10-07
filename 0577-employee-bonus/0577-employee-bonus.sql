SELECT Bonus.bonus, Employee.name
FROM Employee
LEFT JOIN Bonus
    ON Employee.empId = Bonus.empId
WHERE IFNULL (Bonus.bonus, 0) < 1000;