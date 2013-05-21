package rubikscubesolver;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Stack;
import javax.swing.JComponent;

enum Layer
{
    UP,
    DOWN,
    RIGHT,
    LEFT,
    FRONT,
    BACK,
    X_MIDDLE,
    Y_MIDDLE,
    Z_MIDDLE,
}

public class RubiksCube extends JComponent
{
    private Color[][] up;
    private Color[][] down;
    private Color[][] left;
    private Color[][] right;
    private Color[][] front;
    private Color[][] back;
    
    private Color upColor;
    private Color downColor;
    private Color leftColor;
    private Color rightColor;
    private Color frontColor;
    private Color backColor;
    
    private int moveCount;
    
    // Used for optomizing the solver.
    private Layer prevLayer;
    private int prevTurns;
    
    public final int width = 50;
    public final int space = 5;
    
    public RubiksCube()
    {
	up = new Color[3][3];
	down = new Color[3][3];
	left = new Color[3][3];
	right = new Color[3][3];
	front = new Color[3][3];
	back = new Color[3][3];
	
	upColor = Color.YELLOW;
	downColor = Color.WHITE;
	leftColor = Color.BLUE;
	rightColor = Color.GREEN;
	frontColor = Color.RED;
	backColor = new Color(255, 160, 0);
	
	resetCube();
	
	setSize((width * 9) + (space * 8), (width * 12) + (space * 11));
    }

    public void resetCube()
    {
	for (int x = 0; x < 3; x++)
	{
	    for (int y = 0; y < 3; y++)
	    {
		up[x][y] = upColor;
		down[x][y] = downColor;
		left[x][y] = leftColor;
		right[x][y] = rightColor;
		front[x][y] = frontColor;
		back[x][y] =  backColor;
	    }
	}
	
	moveCount = 0;
	prevLayer = null;
	prevTurns = 0;
    }
    
    public boolean hasWon()
    {
	boolean won = true;
	Color[] faceColors = new Color[6];
	
	faceColors[0] = up[0][0];
	faceColors[1] = down[0][0];
	faceColors[2] = left[0][0];
	faceColors[3] = right[0][0];
	faceColors[4] = front[0][0];
	faceColors[5] = back[0][0];
	
	for (int x = 0; x < 3; x++)
	{
	    for (int y = 0; y < 3; y++)
	    {
		if (up[x][y] != faceColors[0])
		    return false;
		if (down[x][y] != faceColors[1])
		    return false;
		if (left[x][y] != faceColors[2])
		    return false;
		if (right[x][y] != faceColors[3])
		    return false;
		if (front[x][y] != faceColors[4])
		    return false;
		if (back[x][y] != faceColors[5])
		    return false;
	    }
	}
	
	return true;
    }
    
    public String solve()
    {
	if (hasWon())
	    return "Solved!";
	
	Stack<Layer> turnFaceStack = new Stack<Layer>();
	Stack<Integer> turnNumStack = new Stack<Integer>();
	prevLayer = null;
	prevTurns = 0;
	
	// Solve recursively
	solverHelper(turnFaceStack, turnNumStack);
	
	String result = "";
	int size = turnFaceStack.size();
	
	for (int i = 0; i < size; i++)
	{
	    Layer turn = turnFaceStack.pop();
	    int num = turnNumStack.pop();
	    String part = "";
	    
	    // Cube face notation
	    switch (turn)
	    {
		case UP:
		    part = "U";
		    break;
		case DOWN:
		    part = "D";
		    break;
		case LEFT:
		    part = "L";
		    break;
		case RIGHT:
		    part = "R";
		    break;
		case FRONT:
		    part = "F";
		    break;
		case BACK:
		    part = "B";
		    break;
		case X_MIDDLE:
		    part = "E";
		    break;
		case Y_MIDDLE:
		    part = "S";
		    break;
		case Z_MIDDLE:
		    part = "M";
		    break;
	    }
	    
	    // 2 = twice and ' = counter-clock wise
	    switch (num)
	    {
		case 1:
		    // Don't add anything.
		    break;
		case 2:
		case -2:
		    part += "2";
		    break;
		case 3:
		case -1:
		    part += "'";
		    break;
	    }
	    
	    result += part;
	    if (i >= size - 1)
		result += " ";
	}
	
	return result;
    }
    
    private void solverHelper(Stack<Layer> turnFaceStack, Stack<Integer> turnNumStack)
    {
	if (hasWon())
	    return;
	
	Layer nextLayer = null;
	int nextTurns = 0;
	
	for (int face = 0; face < 9; face++)
	{
	    nextLayer = getNextTurn(nextLayer);
	    
	    for (int turns = 1; turns <= 4; turns++)
	    {
		rotateFace(nextLayer, 1);
		
		// Turned full circle, get new face.
		if (turns == 4)
		{
		    break;
		}
		
		turnFaceStack.push(nextLayer);
		turnNumStack.push(turns);
		
		if (turnFaceStack.size() < 20)
		{
		    //System.out.println(turnFaceStack.size() + ", " + turnNumStack.size());
		    System.out.println(turnFaceStack.peek() + ", " + turnNumStack.peek());
		    solverHelper(turnFaceStack, turnNumStack);
		}
		
		if (hasWon())
		    return;
		
		turnFaceStack.pop();
		turnNumStack.pop();
	    }
	}
	
	turnFaceStack.pop();
	turnNumStack.pop();
    }
    
    private Layer getNextTurn(Layer prevFace)
    {
	if (prevFace == null)
	    return Layer.UP;
	
	switch (prevFace)
	{
	    case UP:
		return Layer.FRONT;
	    case FRONT:
		return Layer.RIGHT;
	    case RIGHT:
		return Layer.DOWN;
	    case DOWN:
		return Layer.BACK;
	    case BACK:
		return Layer.LEFT;
	    case LEFT:
		return Layer.X_MIDDLE;
	    case X_MIDDLE:
		return Layer.Y_MIDDLE;
	    case Y_MIDDLE:
		return Layer.Z_MIDDLE;
	    case Z_MIDDLE:
		return null;
	}
	
	return null;
    }
    
    private int getNextNumTurns(int prevTurns)
    {
	switch (prevTurns)
	{
	    case 0:
		return 1;
	    case 1:
		return 2;
	    case 2:
	    case -2:
		return 3;
	    case 3:
	    case -1:
		return 1;
	}
	
	return 0;
    }
    
    private int getCounterTurn(int turns)
    {
	if (turns == 1)
	    return 3;
	else if (turns == 2)
	    return 2;
	else
	    return 1;
    }
    
    public void rotateFace(Layer cubeFace, int turns)
    {
	turns %= 4;
	
	// When it turns backwards it just
	// calculate 3 times.
	// (Doens't actually turn 3 times.)
	if (turns < 0)
	    turns += 4;
	
	// Don't have to do anything.
	if (turns == 0)
	    return;
	
	// The faces ajacent to the selected face
	Color[][] currFace = getCurr(cubeFace);
	Color[][] upAjacent = getAjcUp(cubeFace);
	Color[][] downAjacent = getAjcDown(cubeFace);
	Color[][] leftAjacent = getAjcLeft(cubeFace);
	Color[][] rightAjacent = getAjcRight(cubeFace);
	
	// Handles ajacent edge face rotations.
	for (int numTurns = 0; numTurns < turns; numTurns++)
	{
	    switch (cubeFace)
	    {
		case UP:
		    // Rotates the first squares on each side (0),
		    // then the middle squares (1),
		    // then the last squares (2).
		    for (int i = 0; i < 3; i++)
		    {
			Color temp = leftAjacent[2][i];
			leftAjacent[2][i] = downAjacent[2 - i][0];
			downAjacent[2 - i][0] = rightAjacent[2][i];
			rightAjacent[2][i] = upAjacent[2 - i][0];
			upAjacent[2 - i][0] = temp;
		    }

		    break;
		case DOWN:
		    for (int i = 0; i < 3; i++)
		    {
			Color temp = leftAjacent[0][i];
			leftAjacent[0][i] = downAjacent[2 - i][2];
			downAjacent[2 - i][2] = rightAjacent[0][i];
			rightAjacent[0][i] = upAjacent[2 - i][2];
			upAjacent[2 - i][2] = temp;
		    }

		    break;
		case LEFT:
		    for (int i = 0; i < 3; i++)
		    {
			Color temp = leftAjacent[2][2 - i];
			leftAjacent[2][2 - i] = downAjacent[2][2 - i];
			downAjacent[2][2 - i] = rightAjacent[0][i];
			rightAjacent[0][i] = upAjacent[0][i];
			upAjacent[0][i] = temp;
		    }
		    
		    break;
		case RIGHT:
		    for (int i = 0; i < 3; i++)
		    {
			Color temp = leftAjacent[2][i];
			leftAjacent[2][i] = downAjacent[0][2 - i];
			downAjacent[0][2 - i] = rightAjacent[0][2 - i];
			rightAjacent[0][2 - i] = upAjacent[2][i];
			upAjacent[2][i] = temp;
		    }
		    
		    break;
		case FRONT:
		    for (int i = 0; i < 3; i++)
		    {
			Color temp = leftAjacent[i][0];
			leftAjacent[i][0] = downAjacent[i][2];
			downAjacent[i][2] = rightAjacent[2 - i][2];
			rightAjacent[2 - i][2] = upAjacent[i][2];
			upAjacent[i][2] = temp;
		    }
		    
		    break; 
		case BACK:
		    for (int i = 0; i < 3; i++)
		    {
			Color temp = leftAjacent[2 - i][0];
			leftAjacent[2 - i][0] = downAjacent[i][0];
			downAjacent[i][0] = rightAjacent[i][2];
			rightAjacent[i][2] = upAjacent[i][0];
			upAjacent[i][0] = temp;
		    }

		    break;
		case X_MIDDLE:
		    for (int i = 0; i < 3; i++)
		    {
			Color temp = leftAjacent[1][i];
			leftAjacent[1][i] = downAjacent[2 - i][1];
			downAjacent[2 - i][1] = rightAjacent[1][i];
			rightAjacent[1][i] = upAjacent[2 - i][1];
			upAjacent[2 - i][1] = temp;
		    }

		    break;
		case Z_MIDDLE:
		    for (int i = 0; i < 3; i++)
		    {
			Color temp = leftAjacent[1][2 - i];
			leftAjacent[1][2 - i] = downAjacent[1][2 - i];
			downAjacent[1][2 - i] = rightAjacent[1][i];
			rightAjacent[1][i] = upAjacent[1][i];
			upAjacent[1][i] = temp;
		    }
		    
		    break;
		case Y_MIDDLE:
		    for (int i = 0; i < 3; i++)
		    {
			Color temp = leftAjacent[2 - i][1];
			leftAjacent[2 - i][1] = downAjacent[i][1];
			downAjacent[i][1] = rightAjacent[i][1];
			rightAjacent[i][1] = upAjacent[i][1];
			upAjacent[i][1] = temp;
		    }
		    
		    break;
	    }
	}
	
	// If its a middle slice thats move, skip the face rotation.
	if (currFace != null)
	{
	    // These faces turn the wrong way, so reverse the direction to fix.
	    switch (cubeFace)
	    {
		case BACK:
		case FRONT:
		case DOWN:
		case UP:
		    turns = getCounterTurn(turns);
	    }
	    
	    // -------- Handles face rotation --------
	    Point[] rotatedSpots = new Point[4];
	    Color[] rotatedValues = new Color[4];

	    // --------------- Corners ---------------
	    rotatedSpots[0] = getRotatedSpot(turns, 0, 0);
	    rotatedSpots[1] = getRotatedSpot(turns, 0, 2);
	    rotatedSpots[2] = getRotatedSpot(turns, 2, 2);
	    rotatedSpots[3] = getRotatedSpot(turns, 2, 0);

	    for (int i = 0; i < 4; i++)
		rotatedValues[i] = currFace[rotatedSpots[i].x][rotatedSpots[i].y];

	    currFace[0][0] = rotatedValues[0];
	    currFace[0][2] = rotatedValues[1];
	    currFace[2][2] = rotatedValues[2];
	    currFace[2][0] = rotatedValues[3];

	    // ---------------- Edges ----------------
	    rotatedSpots[0] = getRotatedSpot(turns, 1, 0);
	    rotatedSpots[1] = getRotatedSpot(turns, 2, 1);
	    rotatedSpots[2] = getRotatedSpot(turns, 1, 2);
	    rotatedSpots[3] = getRotatedSpot(turns, 0, 1);

	    for (int i = 0; i < 4; i++)
		rotatedValues[i] = currFace[rotatedSpots[i].x][rotatedSpots[i].y];

	    currFace[1][0] = rotatedValues[0];
	    currFace[2][1] = rotatedValues[1];
	    currFace[1][2] = rotatedValues[2];
	    currFace[0][1] = rotatedValues[3];
	}
	
	moveCount++;
	prevLayer = cubeFace;
	prevTurns = turns;
    }
    
    private Color[][] getCurr(Layer cubeFace)
    {
	switch (cubeFace)
	{
	    case UP:
		return up;
	    case DOWN:
		return down;
	    case LEFT:
		return left;
	    case RIGHT:
		return right;
	    case FRONT:
		return front;
	    case BACK:
		return back;
	    case X_MIDDLE:
		return null;
	    case Y_MIDDLE:
		return null;
	    case Z_MIDDLE:
	    default:
		return null;
	}
    }
    
    private Color[][] getAjcUp(Layer cubeFace)
    {
	switch (cubeFace)
	{
	    case UP:
		return back;
	    case DOWN:
		return front;
	    case LEFT:
		return up;
	    case RIGHT:
		return up;
	    case FRONT:
		return up;
	    case BACK:
		return up;
	    case X_MIDDLE:
		return back;
	    case Y_MIDDLE:
		return down;
	    case Z_MIDDLE:
	    default:
		return up;
	}
    }
    
    private Color[][] getAjcDown(Layer cubeFace)
    {
	switch (cubeFace)
	{
	    case UP:
		return front;
	    case DOWN:
		return back;
	    case LEFT:
		return down;
	    case RIGHT:
		return down;
	    case FRONT:
		return down;
	    case BACK:
		return down;
	    case X_MIDDLE:
		return front;
	    case Y_MIDDLE:
		return up;
	    case Z_MIDDLE:
	    default:
		return down;
	}
    }
    
    private Color[][] getAjcLeft(Layer cubeFace)
    {
	switch (cubeFace)
	{
	    case UP:
		return left;
	    case DOWN:
		return left;
	    case LEFT:
		return back;
	    case RIGHT:
		return front;
	    case FRONT:
		return left;
	    case BACK:
		return right;
	    case X_MIDDLE:
		return left;
	    case Y_MIDDLE:
		return right;
	    case Z_MIDDLE:
	    default:
		return back;
	}
    }
    
    private Color[][] getAjcRight(Layer cubeFace)
    {
	switch (cubeFace)
	{
	    case UP:
		return right;
	    case DOWN:
		return right;
	    case LEFT:
		return front;
	    case RIGHT:
		return back;
	    case FRONT:
		return right;
	    case BACK:
		return left;
	    case X_MIDDLE:
		return right;
	    case Y_MIDDLE:
		return left;
	    case Z_MIDDLE:
	    default:
		return front;
	}
    }
    
    // Helper method makes code more readable.
    private Point getRotatedSpot(int turns, int x, int y)
    {
	Point newSpot = new Point(x, y);
	
	if (turns == 1) // x and y are dependent w/ each other on single turns.
	{
	    if (x == 0 && y == 0)
	    {
		newSpot.x = 2;
		newSpot.y = 0;
	    } else if (x == 2 && y == 0)
	    {
		newSpot.x = 2;
		newSpot.y = 2;
	    } else if (x == 2 && y == 2)
	    {
		newSpot.x = 0;
		newSpot.y = 2;
	    } else if (x == 0 && y == 2)
	    {
		newSpot.x = 0;
		newSpot.y = 0;
	    } else if (x == 1 && y == 0)
	    {
		newSpot.x = 2;
		newSpot.y = 1;
	    } else if (x == 2 && y == 1)
	    {
		newSpot.x = 1;
		newSpot.y = 2;
	    } else if (x == 1 && y == 2)
	    {
		newSpot.x = 0;
		newSpot.y = 1;
	    } else if (x == 0 && y == 1)
	    {
		newSpot.x = 1;
		newSpot.y = 0;
	    }
	} else if (turns == 2) // x and y are not dependent w/ 2 turns.
	{
	     if (x == 0)
		 newSpot.x = 2;
	     else if (x == 1)
		 newSpot.x = 1;
	     else
		 newSpot.x = 0;

	     if (y == 0)
		 newSpot.y = 2;
	     else if (y == 1)
		 newSpot.y = 1;
	     else
		 newSpot.y = 0;
	} else if (turns == 3)
	{
	    // Instead of using lots of ifs, uses the turn 1 ifs 3 times.
	    for (int i = 0; i < 3; i++)
		newSpot = getRotatedSpot(1, newSpot.x, newSpot.y);
	}
	
	return newSpot;
    }
    
    @Override
    protected void paintComponent(Graphics g)
    {
	/* Format:
	 *   B
	 * L T R
	 *   F
	 *   B
	 */
	
	// Black background
	g.setColor(Color.BLACK);
	g.fillRect(-1, -1, (width * 9) + (space * 8), (width * 12) + (space * 11));
	
	// Back face
	for (int x = 0; x < 3; x++)
	{
	    for (int y = 0; y < 3; y++)
	    {
		g.setColor(back[2 - x][2 - y]);
		
		// Empty space needs to be accounted for.
		int emptySpaceX = (width * 3) + (space * 3) + (space * x);
		int emptySpaceY = (space * y);
		g.fillRect(x * width + emptySpaceX, y * width + emptySpaceY, width, width);
	    }
	}
	
	// Left face
	for (int x = 0; x < 3; x++)
	{
	    for (int y = 0; y < 3; y++)
	    {
		g.setColor(left[x][2 - y]);
		
		// Empty space needs to be accounted for.
		int emptySpaceX = (space * x);
		int emptySpaceY = (width * 3) + (space * 3) + (space * y);
		g.fillRect(x * width + emptySpaceX, y * width + emptySpaceY, width, width);
	    }
	}
	
	// Up face
	for (int x = 0; x < 3; x++)
	{
	    for (int y = 0; y < 3; y++)
	    {
		g.setColor(up[x][y]);
		
		// Empty space needs to be accounted for.
		int emptySpaceX = (width * 3) + (space * 3) + (space * x);
		int emptySpaceY = (width * 3) + (space * 3) + (space * y);
		g.fillRect(x * width + emptySpaceX, y * width + emptySpaceY, width, width);
	    }
	}
	
	// Right face
	for (int x = 0; x < 3; x++)
	{
	    for (int y = 0; y < 3; y++)
	    {
		g.setColor(right[2 - x][y]);
		
		// Empty space needs to be accounted for.
		int emptySpaceX = ((width * 3) + (space * 3)) * 2 + (space * x);
		int emptySpaceY = (width * 3) + (space * 3) + (space * y);
		g.fillRect(x * width + emptySpaceX, y * width + emptySpaceY, width, width);
	    }
	}
	
	// Front face
	for (int x = 0; x < 3; x++)
	{
	    for (int y = 0; y < 3; y++)
	    {
		g.setColor(front[x][y]);
		
		// Empty space needs to be accounted for.
		int emptySpaceX = (width * 3) + (space * 3) + (space * x);
		int emptySpaceY = ((width * 3) + (space * 3)) * 2 + (space * y);
		g.fillRect(x * width + emptySpaceX, y * width + emptySpaceY, width, width);
	    }
	}
	
	// Down face
	for (int x = 0; x < 3; x++)
	{
	    for (int y = 0; y < 3; y++)
	    {
		g.setColor(down[2 - x][2 - y]);
		
		// Empty space needs to be accounted for.
		int emptySpaceX = (width * 3) + (space * 3) + (space * x);
		int emptySpaceY = ((width * 3) + (space * 3)) * 3 + (space * y);
		g.fillRect(x * width + emptySpaceX, y * width + emptySpaceY, width, width);
	    }
	}
    }
}