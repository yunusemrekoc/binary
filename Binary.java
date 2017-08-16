//Binary Simulator Program.
//by www.neiljohan.com

import java.io.*;

public class Binary
{
    public static void main(String[] pArgs) throws IOException
        {
            menu();
        }

    public static void menu() throws IOException
        {
            System.out.println("-----------------------------------------");
            System.out.println("Pick an Option");
            System.out.println("0 - Decimal -> Binary");
            System.out.println("1 - Binary  -> Decimal");
            System.out.println("2 - Add 2 binary numbers");
            System.out.println("3 - Convert to 2's Complement");
            System.out.println("4 - Quit");
            int tOption = NeilClass.GetInputInt("Please choose an option ");
            
            switch (tOption)
            {
                case 0:
                {
                    int tDecNumber = NeilClass.GetInputInt("Type in a number (0-255) ");
                    final BinaryInterface tBinary = new BinaryClass(tDecNumber);
                    String Binary1 = tBinary.toBinary();
                    System.out.println(Binary1);
                    menu();
                    break;
                }
                case 1:
                {
                    String tBinNumber = NeilClass.GetInputString("Type in an 8 bit binary number ");
                    final BinaryInterface tBinary = new BinaryClass(tBinNumber);
                    int Decimal1 = tBinary.toDecimal();
                    System.out.println(Decimal1);
                    menu();
                    break;
                }
                case 2:
                {
                     String tBin1 = NeilClass.GetInputString("8 bit binary number   ");
                     String tBin2 = NeilClass.GetInputString("8 bit binary number + ");
                     final BinaryInterface tBinary = new BinaryClass(tBin1,tBin2);
                     String Result = tBinary.BinaryAdd(tBin1,tBin2);
                     System.out.println("The result is " + Result);
                     menu();
                     break;
                }
                case 3:
                {
                    String t2BinNumber = NeilClass.GetInputString("Type in an 8 bit binary number ");
                    final BinaryInterface tBinary = new BinaryClass(t2BinNumber);
                    String BinTwosComplement = tBinary.TwosComplement();
                    System.out.println(BinTwosComplement);
                    menu();
                    break;
                }
                case 4:
                {
                    System.exit(1);
                    break;
                }
                default:
                {
                    menu();
                }
                
                
            }
        }
}

            

