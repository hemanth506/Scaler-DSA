type User = {
  id: number;
  name: string;
};

function updateUser(_user: Pick<User, 'id'> & Partial<Omit<User, 'id'>>) {}
