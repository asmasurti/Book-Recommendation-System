# Book-Recommendation-System
A book recommendation system where users can rate books and have books recommended to them based on ones they have already read and their previous ratings. 
This project was created in my final year of high school as part of a culminating assignment for a computer science course. The software has multiple pages created using using OOP, Java, and Java Applet.  

## Home Page
The following is the home page with an option to log in or create a new user: 

![Home Page](/images/homePage.PNG)

## Login and Signup 
- The login page allows exsiting users to access their account and provides error messages for when an incorrect password or username is entered
- Similarly, the signup page allows new users to create an account and gives error messaged for when a user with the same name already exisits

Login Page                        |  Signup Page
:--------------------------------:|:-------------------------:
![Login Page](/images/logIn.PNG)  |  ![Signup Page](/images/signUp.PNG)

## Landing Page 
The landing page displays all the potential options the user has. All the pages have a "Log Out" button in case the user wants to sign out and return to the Home Page. Additionally, all pages have a "Back" button to return to the Landing Page.   

#### 1. User Profile 
- The user can:
  - View the number of books they have read from the database of books 
  - Change their username or password

![User Profile Page](/images/userProfile.PNG)

#### 2. Add a Book 
- The system is initialized to a default list of 55 books
- The user can add any other books that they want 
- Error messages are provided if the user attempts to add a book that already exists, or enters and invalid ISBN number

![Add a Book Page](/images/addBook.PNG)

#### 3. Recommended Books 
- This page provides recommeded books based on the books the user has previously read and the ratings provided for them
- The recommendation algorithm uses a version of matrix factorization where the user's read books and ratings are compared to that of all other users to determine what books to suggest

![Recommended Books Page](/images/recommendedBooks.PNG)

#### 4. Rate a Book
- The user can: 
  - Select a book from the drop down menu which leads to the next page 
  - Change selection (back to previous page) or rate a book on a scale from -5 to 5 (a coressponding icon is displayed for each selection) 
- Once a book has been rated a message is displayed and the option to rate another book is given 

Select a Book                            |  Rate the Book                             | Rated Book Message
:---------------------------------------:|:------------------------------------------:|:----------------------------------------:
![Select Book](/images/rateBookOne.PNG)  |  ![Rate Book](/images/rateBookTwo.PNG)     | ![Rate Book Message](/images/rateBookThree.PNG)

#### 5. Rated Books 
- If the user has not rated any books yet, they are given the option to redirect to the Rate a Book page
- If books have been rated, they can be searched for based on the rating given 

![Rated Books Page](/images/ratedBooks.PNG)  

#### 6. Change a Rating 
- The user can change a rating for a book they have previously rated by selecting it from a dropdown menu 
- A similar page to Rate a Book is displayed where the rating can be updated

![Change a Rating Page](/images/changeRating.PNG)  




