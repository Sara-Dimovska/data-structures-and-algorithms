using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;

namespace BinaryTree_traversals
{

    public partial class Form1 : Form
    {
        //klasa za jazel
        public class Node
        {
            public int value;
            public Node left, right;

            public Node(){}
            public Node(int value)
            {
                this.value = value;
                left = right = null;
            }

        }

        public class BinaryTree
        {
            //so ovaa promenliva gi izminuvame site clenovi na preorder od pocetok do kraj 
            // sekoj nareden clen/jazol od preorder,se bara vo inorder
            int preIndex = 0;

            public Node Tree(int[] inorder, int[] preorder, int pocetok, int kraj)
            {


                // nevozmozno da se izgradi drvo 
                if (pocetok > kraj)
                    return null;

                //se formira  jazol 
                Node node = new Node(preorder[preIndex++]);

                //ako ima samo edinstven clen/eden jazol
                if (pocetok == kraj)
                    return node;

                //se bara indeksot vo inorder nizata za da ponatamu se formiraat podnizi
                int in_Index = search(inorder, pocetok, kraj, node.value);
                


                //za levo i desno podsteblo na jazol,rekurzivno
                node.left = Tree(inorder, preorder, pocetok, in_Index - 1);
                node.right = Tree(inorder, preorder, in_Index + 1, kraj);

                return node;
            }
            


            //pomoshna,se upotrebuva za da se najde indeksot na barana vrednost
            //vo slucajot ja koristime za vrednosta zemena od preorder
            public int search(int[] arr, int start, int end, int value)
            {
                int i;
                for (i = start; i <= end; i++)
                {
                    if (arr[i] == value)
                        break;

                }
                return i;
            }

            //output
            public string postorder(Node root)
            {
               
                string izlez = "";

                if (root == null)
                    return "";

                Stack<Node> stack1 = new Stack<Node>();//pomoshen
                Stack<Node> stack2 = new Stack<Node>();//podreden 

                stack1.Push(root);

                Node temp = new Node();
                while (stack1.Count() > 0)
                {
                    temp = stack1.Pop();
                    //vo vtoriot stek kje se stavaat koren,desno,levo za da moze koga kje se vadat
                    //da bide levo,desno,koren
                    stack2.Push(temp);

                    if (temp.left != null)
                        stack1.Push(temp.left);

                    if (temp.right != null)
                        stack1.Push(temp.right);
                }

                //smestuvame vo string
                while (stack2.Count() > 0)
                {
                    temp = stack2.Pop();
                    izlez += temp.value.ToString() + ",";
                }
                return izlez;
            }

        }

        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }
       
        private void button1_Click(object sender, EventArgs e)
        {
           
            
            string inorder_string = textBox1.Text;
            string preorder_string = textBox2.Text;

            
                textBox1.Enabled = false;
                textBox2.Enabled = false;
                button1.Enabled = false;

                //od string vo niza
                int[] inorder_array = Array.ConvertAll(inorder_string.Split(','), int.Parse);
                int[] preorder_array = Array.ConvertAll(preorder_string.Split(','), int.Parse);


            //mora da imaat isti dolzini dvete nizi
            if (Validiraj_dolzini(inorder_array, preorder_array))
            {
                //instanca 
                BinaryTree tree = new BinaryTree();

                //dolzina
                int n = inorder_array.Length;

                //call
                Node root = tree.Tree(inorder_array, preorder_array, 0, n - 1);

                //output
                string izlez = tree.postorder(root);
                textBox3.Text = izlez;
            }
           

        }
        private  bool Validiraj_dolzini(int [] niza1,int [] niza2)
        {
            if (niza1.Length == niza2.Length)
                return true;
            else
            {
                MessageBox.Show("Vnesete ednakvi dolzini na dvete nizi!");
                textBox1.Text = "";
                textBox2.Text = "";
                textBox3.Text = "";
                textBox1.Enabled = true;
                textBox2.Enabled = true;
                button1.Enabled = true;
                textBox1.Focus();

                return false;
            }
        }

        //od pocetok
        private void inputToolStripMenuItem_Click(object sender, EventArgs e)
        {
            textBox1.Text = "";
            textBox2.Text = "";
            textBox3.Text = "";

            textBox1.Enabled = true;
            textBox2.Enabled = true;
            button1.Enabled = true;
        }

        private void aboutToolStripMenuItem_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Inorder vnes:Levo,Roditel,Desno dete. \n Preorder vnes:Roditel,Levo,Desno. \n Ve molime zapazete go redosledot.");

        }

        //validacija na vnesovi
        private void textBox2_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (e.KeyChar != ',' && (!char.IsDigit(e.KeyChar)) && !char.IsControl(e.KeyChar))
                e.Handled = true;
        }

        private void textBox1_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (e.KeyChar != ',' &&  (!char.IsDigit(e.KeyChar)) && !char.IsControl(e.KeyChar) )
                e.Handled = true;
        }

       
        //datoteki
        private void inorderToolStripMenuItem_Click(object sender, EventArgs e)
        {
            OpenFileDialog openFileDialog1 = new OpenFileDialog();
            openFileDialog1.Filter = " All files (*.*)| *.*";
            openFileDialog1.Title = "proba";

            if (openFileDialog1.ShowDialog() == DialogResult.OK)
            {
                this.Text = openFileDialog1.FileName;
                System.IO.StreamReader text = new StreamReader(openFileDialog1.FileName);
                textBox1.Text = text.ReadToEnd();
                text.Close();
            }
        }

        private void preorderToolStripMenuItem_Click(object sender, EventArgs e)
        {
            OpenFileDialog openFileDialog1 = new OpenFileDialog();
            openFileDialog1.Filter = " All files (*.*)| *.*";
            openFileDialog1.Title = "proba";

            if (openFileDialog1.ShowDialog() == DialogResult.OK)
            {
                this.Text = openFileDialog1.FileName;
                System.IO.StreamReader text = new StreamReader(openFileDialog1.FileName);
                textBox2.Text = text.ReadToEnd();
                text.Close();
            }
        }
    }
}
//primer:
// in: 3,5,7,10,13,15,17,20,21,25,28,30,26,40,45";
// pre:"20,10,5,3,7,15,13,17,30,25,21,28,40,36,45";

// post:3,7,5,13,17,15,10,21,28,25,36,45,40,30,20,