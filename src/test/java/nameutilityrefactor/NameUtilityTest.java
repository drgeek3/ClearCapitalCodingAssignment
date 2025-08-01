package nameutilityrefactor;

import org.testng.Assert;
import org.testng.annotations.Test;

import static javacoderefactor.NameUtility.convertNameToInitials;

public class NameUtilityTest {
    @Test
    public void NameConverterTest(){
        //The three results indicated in the assignment
        Assert.assertEquals(convertNameToInitials("Bruno Mars"), "B.M.");
        Assert.assertEquals(convertNameToInitials("Dave M Jones"), "D.M.J.");
        Assert.assertEquals(convertNameToInitials("MichaelSmith"), "M.");
        //Names that go beyond the standard three
        Assert.assertEquals(convertNameToInitials("Sarah Cynthia Sylvia Stout"), "S.C.S.S.");
        Assert.assertEquals(convertNameToInitials("Adolph Blaine Charles David Earl Frederick Gerald Hubert Irvin " +
                "John Kenneth Lloyd Martin Nero Oliver Paul Quincy Randolph Sherman Thomas Uncas Victor William Xerxes Yancy Zeus " +
                "Wolfeschlegelsteinhausenbergerdorff"), "A.B.C.D.E.F.G.H.I.J.K.L.M.N.O.P.Q.R.S.T.U.V.W.X.Y.Z.W.");
        //Extra spaces
        Assert.assertEquals(convertNameToInitials("  William    Martin     Joel   "), "W.M.J.");
        Assert.assertEquals(convertNameToInitials(" Reginald  Dwight               "), "R.D.");
        //null and space values
        Assert.assertEquals(convertNameToInitials(null), "");
        Assert.assertEquals(convertNameToInitials(""), "");
        Assert.assertEquals(convertNameToInitials("        "), "");
        //Other oddities
        Assert.assertEquals(convertNameToInitials("Space, the final frontier."), "S.t.f.f.");
        Assert.assertEquals(convertNameToInitials("Jill Terra-Oppenheimer"), "J.T.");
        Assert.assertEquals(convertNameToInitials("T'Pau K'nak-Tillerman"), "T.K.");

        //Some not equals checks
        Assert.assertNotEquals(convertNameToInitials("Bruno Mars"), "A.C.");
        Assert.assertNotEquals(convertNameToInitials("James T Kirk"), "J.L.P.");
    }
}
