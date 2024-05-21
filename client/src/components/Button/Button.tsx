import styles from "./styles.module.css";

type Props = {
  text: string;
  onClick: () => void;
  disabled?: boolean;
};

const Button: React.FC<Props> = ({ text, onClick, disabled }) => {
  return (
    <button
      className={styles.button + (disabled ? ` ${styles.disabled}` : "")}
      onClick={onClick}
      disabled={disabled}
    >
      {text}
    </button>
  );
};

export { Button };
