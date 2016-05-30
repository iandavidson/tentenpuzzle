# Grid Design Info
For rendering an **unassigned** cell, use the following layout (assume 2 digit numbers for now):

    ||----||----||
    || 0  || 0  ||  ...
    ||  0 ||  1 ||
    ||----||----||
    || 1  || 1  ||  ...
    ||  0 ||  1 ||
    ||----||----||

For rendering an **assigned** cell, use the following layout:

    ||----||----||
    || ** || 0  ||  ...
    || ** ||  1 ||
    ||----||----||
    || ** || ** ||  ...
    || ** || ** ||
    ||----||----||
