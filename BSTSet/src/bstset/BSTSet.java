/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bstset;

/**
 *
 * @author aravinsivakumar
 */
public class BSTSet {

   TNode root;
   
   public BSTSet(){
    root=null;  
}
  
   public BSTSet(int [] input){
       
       root= new TNode(input[0],null,null);
       
       for (int i=1; i<input.length;i++){
           this.add(input[i]);
       }
   }
   
  public void add(int v){
      
        TNode t= this.root;
        
        
         while (t!=null){
             
             if (t.element<v){
                 if (t.right==null){
                 t.right=new TNode (v,null,null);
                 return;
                 }
                 t=t.right;
             }
             
             else if (t.element>v){
                 if (t.left==null){
                     t.left= new TNode (v,null,null);
                     return;
                     
                 }
                 t=t.left;
             }
             
             else{
                 return;
                 
             }
            
         }

  }
  
  
  private TNode removere (int v,TNode t){
  
      if (v>t.element)
          t.right= removere (v,t.right);
      
      else if (v<t.element){
          t.left= removere (v,t.left);
          
      }
      
      else if (t.right!=null && t.left!=null){
          t.element=findTreeMin(t.right);
          t=t.right;
          while (t!=null){
              t=t.left;
          }
          t=null;
          
      }
      
      else
          t=(t.left!=null)?t.left:t.right;
      
   return t;   
  }
  
  public int findTreeMin(TNode t){
      
      while(t.left!=null){
          t=t.left;
      }
      return (t.element);
      
  }
  
  public boolean remove(int v){
      if (this.isIn(v)==true){
          removere(v,root);
           return true;
      }
      
      else {
          return false;
      }
      
      
      
      
      
  }
  
  public BSTSet union(BSTSet s){
      int [] thiselements= new int [this.size()];
      int [] selements= new int [s.size()];
      
      int r=0;
      int b=0;
      this.toarray(0,this.root,thiselements);
      s.toarray (0,s.root,selements);
      
      int [] combinedelements= new int [thiselements.length+selements.length];
      
      for (int i=0;i<thiselements.length;i++){
          combinedelements[i]= thiselements[i];
      }
      
      for (int j=thiselements.length;j<(thiselements.length+selements.length);j++){
          for (int z=0;z<thiselements.length;z++){
              //if (selements[r]==thiselements[z]){
                //  b=0;
              //}
                  
          }
         // if (b!=0){
          combinedelements [j]= selements[r];
          r++;
         // }
      }
      
     return (new BSTSet (combinedelements));
  }
  
  public BSTSet intersection(BSTSet s){
      
      int [] thiselements= new int [this.size()];
      int [] selements= new int [s.size()];
      
      int r=0;
      int b=0;
      
      this.toarray(0,this.root,thiselements);
      s.toarray (0,s.root,selements);
      
      int [] combinedelements= new int [thiselements.length+selements.length];
      
      
      for (int j=0;j<(selements.length);j++){
          for (int z=0;z<thiselements.length;z++){
              if (selements[j]==thiselements[z]){
                  combinedelements [j]= selements[j];
                 
                 
              }
                  
          }
          //if (b==0){
          //combinedelements [j]= selements[r];
          //r++;
          //}
          
      }
      
     return (new BSTSet (combinedelements));
  }
  
  
  private int size(TNode e){
      
      if (e!=null){
        return (size(e.left)+size(e.right)+1);
  }
      else {
          return 0;
      }
      
  }
  
  
  
  public int size(){
      return size(root);
  }
  
 private int height(TNode b){
     
     if (b!=null){
         
         if (height(b.left)>height(b.right)){
             return (height(b.left)+1);
         }
         
         else 
             return (height (b.right)+1);
     }
     
     else 
         return -1;
     
 }
 
 public int height (){
     return height (this.root);
 }
  
  public int toarray(int v,TNode r,int []elements){
      if (r!=null){
          elements[v]=r.element;
      v++;
      
      if (r.left!=null)
          v= toarray (v,r.left,elements);
      
      
      if (r.right!=null)
          v= toarray(v,r.right,elements);
      
      return v;
      }
      else
          return v;
      }
  
  
  public void printBSTSet (){
      if (root==null) {
          System.out.println ("The set is empty");
      }
      else{
      System.out.print("The set elements are: ");
      printBSTSet(root);
      System.out.print("\n");
  }
  }
  
  private void printBSTSet(TNode t){
           
             if(t!=null){
           printBSTSet(t.left);
           System.out.print(" " + t.element + ", ");
           printBSTSet(t.right);
       }
             
       }
  
  public void printNonRec(){
      
     if(root == null) {
			System.out.println("Binary Search Tree is empty");
			return;
		}
		Stack<TNode> stack = new Stack<TNode>();
		TNode r = root;
		
		//first node , go left
		while(r!= null) {
			stack.push(r); // get all the ones going left
			r = r.left;
		}
		
		while(stack.getSize() > 0) { // while stack not empty
			//root
            r = (TNode)stack.pop(); // get the last one
            System.out.print(r.element + " ");
            if(r.right != null) { //try going right
	            	r = r.right; // traverse right
	            	
	            	while(r != null) { // go left till end
	            		stack.push(r); // later right try left ... 
	            		r=r.left;
	            	}
            }
		}
		System.out.println();
	}
  
      
          
  
  public boolean isIn(int v){
      TNode t= this.root;
        
        
         while (t!=null){
             
             if (t.element<v){
                 t=t.right;
             }
             
             else if (t.element>v){
                 t=t.left;
             }
             
             else{
                 return true;
                 
             }
  }
         return false;
       
       
         
               
}
}
   

