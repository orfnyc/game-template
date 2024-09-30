package general;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashSet;

public class GameNode 
{
    private String name;
    private String type;
    private HashSet<String> tags;
    private ArrayList<GameNode> children;
    private GameNode parent;
    private Transform transform;

    public GameNode(String name)
    {
        this.name = name;
        this.type = "generic";
        this.tags = new HashSet<String>();
        this.children = new ArrayList<GameNode>();
        this.parent = null;
        this.transform = new Transform();
    }

    public GameNode(String name, String type)
    {
        this.name = name;
        this.type = type;
        this.tags = new HashSet<String>();
        this.children = new ArrayList<GameNode>();
        this.parent = null;
        this.transform = new Transform();
    }

    public GameNode(String name, GameNode parent)
    {
        this.name = name;
        this.type = "generic";
        this.tags = new HashSet<String>();
        this.children = new ArrayList<GameNode>();
        this.parent = parent;
        this.transform = new Transform();
        if (!this.parent.hasChild(this))
        {
            this.parent.addChild(this);
        }
    }

    public GameNode(String name, String type, GameNode parent)
    {
        this.name = name;
        this.type = type;
        this.tags = new HashSet<String>();
        this.children = new ArrayList<GameNode>();
        this.parent = parent;
        this.transform = new Transform();
        if (!this.parent.hasChild(this))
        {
            this.parent.addChild(this);
        }
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    

    public void addChild(GameNode n)
    {
        children.add(n);
        if (n.getParent() != this) { n.setParent(this); }
    }

    public void removeChild(GameNode n)
    {
        for (int i = children.size()-1; i >= 0; i--)
        {
            if (children.get(i) == n)
            {
                children.remove(i);
            }
        }
    }

    public ArrayList<GameNode> getChildren()
    {
        return this.children;
    }

    public boolean hasChild(GameNode n)
    {
        for (int i = 0; i < this.children.size(); i++)
        {
            if (this.children.get(i) == n)
            {
                return true;
            }
        }
        return false;
    }

    public GameNode getChildByName(String n)
    {
        for (int i = 0; i < this.children.size(); i++)
        {
            if (this.children.get(i).getName().equals(n))
            {
                return this.children.get(i);
            }
        }
        return null;
    }

    public <T extends GameNode> T getChildByName(String n, Class<T> nodeClass)
    {
        for (int i = 0; i < this.children.size(); i++)
        {
            if (this.children.get(i).getName().equals(n) && nodeClass.isAssignableFrom(children.get(i).getClass()))
            {
                return nodeClass.cast(this.children.get(i));
            }
        }
        return null;
    }

    public ArrayList<GameNode> getChildrenByName(String n)
    {
        ArrayList<GameNode> result = new ArrayList<GameNode>();
        for (int i = 0; i < this.children.size(); i++)
        {
            if (this.children.get(i).getName().equals(n))
            {
                result.add(this.children.get(i));
            }
        }
        return result;
    }

    public GameNode getChildByType(String t)
    {
        for (int i = 0; i < this.children.size(); i++)
        {
            if (this.children.get(i).getType().equals(t))
            {
                return this.children.get(i);
            }
        }
        return null;
    }

    public ArrayList<GameNode> getChildrenByType(String t)
    {
        ArrayList<GameNode> result = new ArrayList<GameNode>();
        for (int i = 0; i < this.children.size(); i++)
        {
            if (this.children.get(i).getType().equals(t))
            {
                result.add(this.children.get(i));
            }
        }
        return result;
    } 

    public <T extends GameNode> T getChildByClass(Class<T> nodeClass)
    {
        for (int i = 0; i < this.children.size(); i++)
        {
            if (nodeClass.isAssignableFrom(children.get(i).getClass()))
            {
                return nodeClass.cast(this.children.get(i));
            }
        }
        return null;
    }

    public GameNode getChildByTag(String t)
    {
        for (int i = 0; i < this.children.size(); i++)
        {
            if (this.children.get(i).hasTag(t))
            {
                return this.children.get(i);
            }
        }
        return null;
    }

    public ArrayList<GameNode> getChildrenByTag(String t)
    {
        ArrayList<GameNode> result = new ArrayList<GameNode>();
        for (int i = 0; i < this.children.size(); i++)
        {
            if (this.children.get(i).hasTag(t))
            {
                result.add(this.children.get(i));
            }
        }
        return result;
    } 

    public boolean hasTag(String t)
    {
        return this.tags.contains(t);
    }

    public void addTag(String t)
    {
        this.tags.add(t);
    }

    public void removeTag(String t)
    {
        this.tags.remove(t);
    }

    public GameNode getParent() 
    {
        return this.parent;
    }

    public void setParent(GameNode n)
    {
        this.parent = n;
    }

    public Transform getTransform()
    {
        return this.transform;
    }

    public void setTransform(Transform transform)
    {
        this.transform = transform;
    }

    public void start()
    {
        for (int n = 0; n < children.size(); n++)
        {
            children.get(n).start();
        }
    }

    public void update(double dt)
    {
        for (int n = 0; n < children.size(); n++)
        {
            children.get(n).update(dt);
        }
    }

    public void draw(Graphics2D g2)
    {
        for (int n = 0; n < children.size(); n++)
        {
            children.get(n).draw(g2);
        }
    }

    public GameNode copyWithoutChildren()
    {
        System.out.println("ERROR incomplete copyWithoutChildren method");
        return null;
    }

    public GameNode copyWithChildren()
    {
        System.out.println("ERROR incomplete copyWithChildrenMethod");
        return null;
    }
}