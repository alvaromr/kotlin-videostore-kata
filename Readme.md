
# Video store kata

Refactoring Kata from M.Fowler's book "Refactoring: Improving the Design of Existing Code"

In the video store there are 3 types of movies tha can be sold:
- Regular movies
- New release movies
- Children movies

The base cost for a regular movie is 2 €. After the 2 day of rental an additional cost of 1.5 € per day is applied (So the additional cost is applied from the 3rd day).

The new release movie has a cost of 3 € per day rented.

The base cost for a children movie is 1.5 €. After the 3 day of rental an additional cost of 1.5 € per day is applied (So the additional cost is applied from the 4th day).

For each video purchased the customer earns 1 frequent renter point and if the video is a new release and is rented for more than 1 days he earns an additional frequent renter point.

We want to print a statement for the videos purchased by a customer and his frequent renter points

## Example:
If the customer <i>Fred</i> purchase
- The game of thrones new release video for 1 day
- Cinderella children video for 2 days
- Mr. Robot regular video for 1 day
- The Hobbit regular video for 3 days

We want to print the following statement:

```
Rental Record for Fred
	The game of thrones	3.0
	Cinderella	1.5
	Mr. Robot	2.0
	The Hobbit	3.5
You owed 10.0
You earned 4 frequent renter points
```

### Additional requirement:

The video store owner changed his mind and asked to have the receipt also in HTML

```html
<!DOCTYPE html>
<html>
  <head>
    <title>Video store - statement for Fred</title>
  </head>
  <body>
    <h1>Rental Record for Fred</h1>
    <ul>
       <li>The game of thrones 3.0</li>
       <li>Cinderella	1.5</li>
       <li>Mr. Robot	2.0</li>
       <li>The Hobbit	3.5</li>
    </ul>
    <br>You owed 10.0
    <br>You earned 4 frequent renter points
  </body>
</html>
```

## Task

Migrate existing java code to kotlin, refactor it, and try to meet the additional requirement.