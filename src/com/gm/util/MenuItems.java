package com.gm.util;

public enum MenuItems {
  ADD {
    @Override
    public String toString() {
      return "Add";
    }
  },
  PRINT {
    @Override
    public String toString() {
      return "Print";
    }
  },
  DELETE {
    @Override
    public String toString() {
      return "Delete";
    }
  },
  SEARCH {
    @Override
    public String toString() {
      return "Search";
    }
  },
  SORT {
    @Override
    public String toString() {
      return "Sort";
    }
  },
  REVERSE {
    @Override
    public String toString() {
      return "Reverse";
    }
    
  },
  LENGTH {
    @Override
    public String toString() {
      return "Length";
    }
  },
  EXIT {
    @Override
    public String toString() {
      return "Exit";
    }
  };
  
};
