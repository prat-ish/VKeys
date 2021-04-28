import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class WelcomeScreen implements Screen {

    private String welcomeText = "Welcome...!";
    private String developerText = "Developer: Pratish Nanandkar";

    private ArrayList<String> options = new ArrayList<>();
    
    public WelcomeScreen() {
        options.add("1. Show Files");
        options.add("2. Options Menu");
        options.add("3. Quit");

    }

    
    
    
    //show welcome Text upon running the app.
    public void intro() {
    	System.out.println(welcomeText);
        System.out.println(developerText);
        System.out.println(" ");
        Show();
    }
   
    public void Show() {
    	System.out.println("---Main Menu---");
    	System.out.println(" ");
        for (String s : options)  {
            System.out.println(s); 
            System.out.println(" ");
        }

    } 

    public void getInput() {
        int selectedOption  = 0;
        while ((selectedOption = this.getOption()) != 3) {
            this.NavigateOption(selectedOption);
        }
    }

    @Override
    public void NavigateOption(int option) {
        switch(option) {

            case 1: // Show Files in Directory
                this.ShowFiles();
                
                this.Show();
                
                break;
                
            case 2: // Show File Options menu
            	ScreenService.setCurrentScreen(ScreenService.FileOptionsScreen);
                ScreenService.getCurrentScreen().Show();
                ScreenService.getCurrentScreen().GetUserInput();
                
                this.Show();
                
                break;
                
            default:
                System.out.println("Invalid Option");
                break;
        }
        
    }

    public void ShowFiles() {

        //TODO: Get the files from the Directory
    	
    	//Finished TODO Task

        System.out.println("Files Present: ");
    	DirectoryService.PrintFiles();

    }
    
    private int getOption() {
        Scanner sc = new Scanner(System.in);

        int returnOption = 0;
        try {
            returnOption = sc.nextInt();
        }
        catch (InputMismatchException ex) {

        }
        return returnOption;

    }
	public void GetUserInput() {
		
		
	}
}