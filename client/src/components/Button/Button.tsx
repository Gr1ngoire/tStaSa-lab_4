import styles from "./styles.module.css";

type Props = {
  text: string;
  onClick: () => void;
};

const Button: React.FC<Props> = ({ text, onClick }) => {
  return (
    <button
      className={styles.button}
      onClick={onClick}
    >
      {text}
    </button>
  );
};

export { Button };
