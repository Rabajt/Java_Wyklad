package wyklad._04dziedziczenie;

class AA {
    int m() { return 1; }
    int test() { return m();}
    int testThis() { return this.test();}
}
class BB extends AA { 
    int m(){ return 2; }//return super.m(); } //return 2;}
//    int testSuper() { return super.test(); }
    int testSuper() { return this.test(); }
    int superOne() { return super.m(); }
//    int test() { return this.m();}
//    int test() { return m();}
}
class CC extends BB { 
    int m() { return 3; }
    int superTwo() {return superOne(); }
    int testSuper() { return super.m(); }
    int test() { return super.m();}

}
class DynWia{
    public static void main(String[] args) {
	AA a = new AA() ;	BB b = new BB() ;	CC c = new CC() ;
	System.out.println(a.test() + " " + a.testThis());
	System.out.println(b.test() + " " + b.testThis() + " " + b.testSuper()); // 1 1 2 // 2 2 2
	System.out.println(c.test() + " " + c.testThis() + " " + c.testSuper() + " " + c.superOne());
  } // 2 2  2 2
}

// b.testThis()  =  A.testThis(b)  =  b.test() = A.test(b) = {this.m()} = b.m() = B.m(b) = 2