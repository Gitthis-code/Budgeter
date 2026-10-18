När jag skapade checkCredentials och gjorde tester för den fick jag en 
error för att jag kunde inte använda .equals om lösenordet inte existerade 
för att platsen i mappen var då null.

Löste problemet genom att göra en containsKey check innan 
(usersCredentials.get(password).equals(username))

Vilket löste problemet. 

-------
https://www.baeldung.com/java-delay-code-execution

Länk för sleep