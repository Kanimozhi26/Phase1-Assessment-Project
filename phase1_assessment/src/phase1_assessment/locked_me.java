package phase1_assessment;
import java.util.Scanner;
import java.io.File;
import java.util.Arrays;
import java.io.IOException;
public class locked_me 
{
	public static void main(String[] args)
	{
		System.out.println("\n--------------------------------\n"+"\n------LOCKEDME APPLICATION------\n"+"\n--------------------------------\n"+"\n----BY-------KANIMOZHI MAHENDRAN\n"+"\n--------------------------------\n");
		File new_folder = new File("new_folder");
		new_folder.mkdir();
		optionSelection(new_folder);
	}
	private static void optionSelection(File new_folder) 
	{
		String[] array = {"1----->SORT THE FILES IN ASCENDING ORDER\n", 
			          "2----->BUSINESS LEVEL OPERATIONS\n",
			          "3----->EXIT THE APPLICATION\n" };
		int[] arr={1,2,3};
		int len=arr.length;
		System.out.println();
		for (int i=0;i<len;i++) 
		{
			System.out.println(array[i]);
		}
		System.out.println("PLEASE ENTER ANY OPTIONS YOU WOULD LIKE TO DO:");
		Scanner scan=new Scanner(System.in);
		int options=scan.nextInt();
		switch(options) 
		{
		case 1:
			String[] file_names=new String[100];
			file_names=new_folder.list();
			if(file_names.length==0) 
			{
				System.out.println("THERE IS NO FILE AND IT IS EMPTY");
			}
			else 
			{
				Arrays.sort(file_names);
				System.out.println("LIST OF FILES: ");
				for(String name:file_names) 
				{
					System.out.println(name);
				}
			}
			optionSelection(new_folder);
			break;
		case 2:
			System.out.println("BUSINESS LEVEL OPERATIONS");
			lockedme(new_folder);
			break;
		case 3:
			System.out.println("-------THANK YOU-------\n "+"---EXITING THE APPLICATION---");
			break;
		default:
			System.out.println("PLEASE ENTER CORRECT option");
			optionSelection(new_folder);
			break;
		}
	}
	private static void lockedme(File new_folder)
	{
		System.out.println("1--->ADD A FILE\n" 
                     + "2--->DELETE A FILE\n" 
			         + "3--->SEARCH FOR A FILE\n" 
                     + "4--->GO BACK TO MAIN MENU\n");
		System.out.println("------------PLEASE ENTER YOUR CHOICE------------");
		Scanner sc=new Scanner(System.in);
		int option=sc.nextInt();
		switch(option) 
		{
	
		case 1:
			System.out.println("Adding a file\n");
			System.out.println("ENTER THE FILE NAME TO BE ADDED");
			String newFile=new Scanner(System.in).nextLine();
			File add_file=new File(new_folder, newFile);
			try
			{
				if(add_file.createNewFile())
				System.out.println("FILE IS ADDED");
				else
				System.out.println("FILE NAME ALREADY EXISTS");
		    } 
			catch(IOException e)
			{
				System.out.println("ERROR :"+e.getMessage());
			}
			lockedme(new_folder);
			break;
	
		case 2:
			System.out.println("DELETE A FILE");
			System.out.println("ENTER THE NAME OF THE FILE TO BE DELETED:");
			String file_name=new Scanner(System.in).nextLine();
			File delete_file=new File(new_folder, file_name);
			if(delete_file.exists()) 
			{
				if(delete_file.delete()) 
				{
					System.out.println("FILE IS DELETED");
				} 
				else
					System.out.println("CAN'T DELETE THE FILE");
			} 
			else
				System.out.println("THE FILE IS NOT FOUND");
				lockedme(new_folder);
				break;
	
		case 3:
			System.out.println("SEARCH FOR A FILE");
			System.out.println("ENTER THE FILE TO BE SEARCHED");
			String s_file=new Scanner(System.in).nextLine();
			File search_file=new File(new_folder, s_file);
			if(search_file.exists()) 
			{
				System.out.println("FILE IS PRESENT");
			} 
			else
				System.out.println("FILE IS NOT PRESENT");
				lockedme(new_folder);
				break;
	
		case 4:
			System.out.println("GO BACK TO MAIN MENU");
			optionSelection(new_folder);
			break;
	
		default:
			System.out.println("PLEASE ENTER CORRECT OPTION");
			lockedme(new_folder);
			break;
		}
	}
}