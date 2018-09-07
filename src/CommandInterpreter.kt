import java.io.InputStream
import java.io.OutputStream
import java.util.*
import kotlin.system.exitProcess

class CommandInterpreter(inputStream: InputStream, outputStream: OutputStream)
{
    val scanner = Scanner(inputStream)
    var wantToQuit = false
    var userNameCreated = false
    var string = ""
    var userName = ""
    var userNameList: MutableList<String> = mutableListOf<String>()

    //
    //Run method
    //
    fun run()
    {
        println("Welcome to this Server you little noob")
        println("Use :help if you need server command list")
        println("Please create a user name using :user command")
        //
        //Create and check if user name is created
        //


        do
        {
            string = scanner.nextLine()
           /* if (string != ":user")
            {
                println("do username")
            }
            if (string == ":user")
            {
                println("enter valid name")
            }

            else if (string.substring(0, 5) != ":user" && string.substring(6) == null)
            {
                println("Pls enter username")
            }

            else if (string.substring(0, 5) == ":user" && string.substring(6) == null)
            {
                println("You have to create a user name using :user command")
            }

*/

            if (string == null)
            {
                println("Please enter username with :user command")
            }

            //Works for setting user name :user + name
            else if (string.substring(0, 5) == ":user" && string.substring(6) != null)
            {
                userName = string.substringAfter(' ')
                println("$userName")
                userNameCreated = true
                userNameList.add(userName)
                //println("This is the list of users" + userNameList)
            }



        }
        while (!userNameCreated)



        //
        //Main input checker after user name is created
        //
        do
        {
            //Input checker
            string = scanner.nextLine()

            //If you enter :quit then we break the loop and stop the scanner
            if (string == ":quit")
            {
                wantToQuit = true
                println("Why are you leaving???")
            }
            //
            //Server list commands using :help
            //
            if (string == ":help")
            {
                println("Server Command List")
                println(":user - set username \n\r" +
                        ":help - get commandlist \n\r" +
                        ":messages - print message history \n\r" +
                        ":users - get userlist \n\r" +
                        ":quit - disconnect from server \n\r" +
                        ":whoami - display username \n\r")
            }
            //
            //Prints out your username
            //
            if (string == ":whoami")
            {
                println("You name is : " + userName)
            }
            //
            //Prints out the user name list of all users in the server
            //
            if (string == ":users")
            {
                println("These are the connected users : $userNameList")
            }
        }
        while (!wantToQuit)
        scanner.close()
    }

}




