import javax.swing.JOptionPane;

public class Equations {
    public static void main(String[] args) {
        while (true) {  // Vòng lặp vô hạn cho phép người dùng thực hiện nhiều lần
            // Hiển thị hộp thoại yêu cầu người dùng chọn loại phương trình cần giải
            String strDuc1 = JOptionPane.showInputDialog(null, 
                "Vui lòng chọn loại phương trình bạn cần giải: \n1. Phương trình bậc nhất " +
                "\n2. Phương trình bậc hai \n3. Hệ phương trình bậc nhất  \n4. Thoát chương trình", 
                "Loại phương trình", JOptionPane.INFORMATION_MESSAGE);
            
            int choice = Integer.parseInt(strHieu1); // Chuyển đổi chuỗi nhập vào thành số nguyên để so sánh

            // Kiểm tra nếu người dùng chọn thoát chương trình
            if (choice == 4) {
                JOptionPane.showMessageDialog(null, "Chương trình đã thoát", "Kết thúc", JOptionPane.INFORMATION_MESSAGE);
                break; // Thoát khỏi vòng lặp
            }

            // Giải phương trình bậc nhất (ax + b = 0)
            else if (choice == 1) {
                String Duc1 = JOptionPane.showInputDialog(null, "Vui lòng nhập a: ", "20225717-Nhập a", JOptionPane.INFORMATION_MESSAGE); // Nhập hệ số a
                String Duc2 = JOptionPane.showInputDialog(null, "Vui lòng nhập b: ", "20225717-Nhập b", JOptionPane.INFORMATION_MESSAGE); // Nhập hệ số b
                
                double a = Double.parseDouble(Duc1);
                double b = Double.parseDouble(Duc2);
                
                // Kiểm tra và giải phương trình bậc nhất
                if (a != 0) {
                    double result = -b / a;
                    JOptionPane.showMessageDialog(null, "Nghiệm của phương trình là: " + result, "20225717-Kết quả", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    // Nếu a = 0 và b = 0, phương trình có vô số nghiệm
                    if (b == 0) {
                        JOptionPane.showMessageDialog(null, "Phương trình đã cho có vô số nghiệm", "20225717-Kết quả", JOptionPane.INFORMATION_MESSAGE);
                    } else { 
                        // Nếu a = 0 và b ≠ 0, phương trình vô nghiệm
                        JOptionPane.showMessageDialog(null, "Phương trình đã cho vô nghiệm", "20225717-Kết quả", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
            // Giải phương trình bậc hai (ax^2 + bx + c = 0)
            else if (choice == 2) {
                String Duc1 = JOptionPane.showInputDialog(null, "Vui lòng nhập a: ", "20225717-Nhập a", JOptionPane.INFORMATION_MESSAGE); // Nhập hệ số a
                String Duc2 = JOptionPane.showInputDialog(null, "Vui lòng nhập b: ", "20225717-Nhập b", JOptionPane.INFORMATION_MESSAGE); // Nhập hệ số b
                String Duc3 = JOptionPane.showInputDialog(null, "Vui lòng nhập c: ", "20225717-Nhập c", JOptionPane.INFORMATION_MESSAGE); // Nhập hệ số c
                
                double a = Double.parseDouble(Duc1);
                double b = Double.parseDouble(Duc2);
                double c = Double.parseDouble(Duc3);
                double delta = b * b - 4 * a * c;  // Tính delta
                
                // Phương trình có hai nghiệm phân biệt khi delta > 0
                if (delta > 0) {
                    double x1 = (-b - Math.sqrt(delta)) / (2 * a);
                    double x2 = (-b + Math.sqrt(delta)) / (2 * a);
                    JOptionPane.showMessageDialog(null, "Phương trình có 2 nghiệm phân biệt: " + x1 + " và " + x2, "20225717-Kết quả", JOptionPane.INFORMATION_MESSAGE);
                } 
                // Phương trình có nghiệm kép khi delta = 0
                else if (delta == 0) {
                    double x = -b / (2 * a);
                    JOptionPane.showMessageDialog(null, "Phương trình có nghiệm kép: " + x, "20225717-Kết quả", JOptionPane.INFORMATION_MESSAGE);
                } 
                // Phương trình vô nghiệm khi delta < 0
                else {
                    JOptionPane.showMessageDialog(null, "Phương trình vô nghiệm", "20225717-Kết quả", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            // Giải hệ phương trình bậc nhất hai ẩn
            else if(choice == 3){
                // Nhập các hệ số của hai phương trình
                String Duc1 = JOptionPane.showInputDialog(null, "Vui lòng nhập a1: ", "20225717-Nhập a1", JOptionPane.INFORMATION_MESSAGE); // Nhập hệ số a1
                String Duc2 = JOptionPane.showInputDialog(null, "Vui lòng nhập b1: ", "20225717-Nhập b1", JOptionPane.INFORMATION_MESSAGE); // Nhập hệ số b1
                String Duc5 = JOptionPane.showInputDialog(null, "Vui lòng nhập c1: ", "20225717-Nhập c1", JOptionPane.INFORMATION_MESSAGE); // Nhập hệ số c1
                String Duc3 = JOptionPane.showInputDialog(null, "Vui lòng nhập a2: ", "20225717-Nhập a2", JOptionPane.INFORMATION_MESSAGE); // Nhập hệ số a2
                String Duc4 = JOptionPane.showInputDialog(null, "Vui lòng nhập b2: ", "20225717-Nhập b2", JOptionPane.INFORMATION_MESSAGE); // Nhập hệ số b2
                String Duc6 = JOptionPane.showInputDialog(null, "Vui lòng nhập c2: ", "20225717-Nhập c2", JOptionPane.INFORMATION_MESSAGE); // Nhập hệ số c2
                
                try {
                    double a1 = Double.parseDouble(Duc1);
                    double b1 = Double.parseDouble(Duc2);
                    double c1 = Double.parseDouble(Duc5);
                    double a2 = Double.parseDouble(Duc3);
                    double b2 = Double.parseDouble(Duc4);
                    double c2 = Double.parseDouble(Duc6);

                    // Tính các định thức
                    double D = a1 * b2 - a2 * b1;
                    double Dx = c1 * b2 - c2 * b1;
                    double Dy = a1 * c2 - a2 * c1;

                    if (D != 0) {
                        // Hệ có nghiệm duy nhất
                        double x = Dx / D;
                        double y = Dy / D;
                        JOptionPane.showMessageDialog(null, "Hệ phương trình có nghiệm duy nhất: (" + x + ", " + y + ")", "20225717-Kết quả", JOptionPane.INFORMATION_MESSAGE);
                    } else if (Dx != 0 || Dy != 0) {
                        // Hệ vô nghiệm
                        JOptionPane.showMessageDialog(null, "Hệ phương trình vô nghiệm", "20225717-Kết quả", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        // Hệ có vô số nghiệm
                        JOptionPane.showMessageDialog(null, "Hệ phương trình có vô số nghiệm", "20225717-Kết quả", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Giá trị nhập vào không hợp lệ. Vui lòng nhập số.", "20225717-Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            // Nếu người dùng nhập sai lựa chọn thì yêu cầu nhập lại
            else {
                JOptionPane.showMessageDialog(null, "Yêu cầu của bạn không hợp lệ. Vui lòng thử lại", "20225717-Errorx", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}